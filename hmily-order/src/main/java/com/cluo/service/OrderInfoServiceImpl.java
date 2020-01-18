package com.cluo.service;

import java.util.HashMap;
import java.util.Map;

import org.dromara.hmily.annotation.Hmily;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cluo.mapper.OrderInfoMapper;
import com.cluo.pojo.OrderInfo;
import com.cluo.response.OrderResponse;

@Service
public class OrderInfoServiceImpl implements OrderInfoService{
    private Logger logger = LoggerFactory.getLogger(OrderInfoServiceImpl.class);
    
	@Autowired
	OrderInfoMapper orderInfoMapper;
	
	@Hmily(confirmMethod="confirmCreateOrder",cancelMethod="cancelCreateOrder")
	@Override
	public Boolean createOrder(OrderInfo orderInfo) {
		logger.info("===执行try创建订单接口===");
		Map<String,Object> map = new HashMap<>();
		int create = orderInfoMapper.tryOrder(orderInfo);
		return true;
	}

	/**
	 * 注意：入参和返回参数要和上面的保持一致
	 * @param orderInfo
	 * @return
	 */
	public Boolean confirmCreateOrder(OrderInfo orderInfo) {
		logger.info("===执行confirm创建订单操作===");
		orderInfo.setDeleted(0); //可用
		int confirm = orderInfoMapper.confirmOrder(orderInfo);
		return true;
	}
	
	public Boolean cancelCreateOrder(OrderInfo orderInfo) {
		logger.info("===执行cancel创建订单操作===");
		try {
			orderInfo.setDeleted(1); //不可用
			int confirm = orderInfoMapper.cancelOrder(orderInfo);
			return true;
		} catch (Exception e) {
			throw new RuntimeException("创建订单失败");
		}
	}
}

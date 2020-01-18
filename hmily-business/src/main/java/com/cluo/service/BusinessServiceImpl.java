package com.cluo.service;

import org.dromara.hmily.annotation.Hmily;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cluo.feign.AccountService;
import com.cluo.feign.OrderInfoService;
import com.cluo.pojo.AccountInfo;
import com.cluo.pojo.OrderInfo;
import com.cluo.request.AccountRequest;
import com.cluo.request.BusinessRequest;
import com.cluo.request.OrderRequest;

@Service
public class BusinessServiceImpl implements BusinessService{
    private Logger logger = LoggerFactory.getLogger(BusinessServiceImpl.class);
	
	@Autowired
	private OrderInfoService orderInfoService;
	@Autowired
	private AccountService accountService;
	
	@Hmily(confirmMethod="confirmBusiness",cancelMethod="cancelBusiness")
	@Override
	public Boolean doBusiness(BusinessRequest businessRequest) {
		logger.info("===进入try节点business===");
		OrderRequest orderRequest = businessRequest.getOrderRequest();
		AccountRequest accountRequest = businessRequest.getAccountRequest();
		if(orderRequest==null || accountRequest==null) {
			throw new RuntimeException("传入的参数为空");
		}
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setDeleted(null);
		BeanUtils.copyProperties(orderRequest, orderInfo);
		Boolean createOrder = orderInfoService.createOrder(orderInfo);
		AccountInfo accountInfo = new AccountInfo();
		BeanUtils.copyProperties(accountRequest, accountInfo);
		accountInfo.setDeleted(null);
		Boolean decreaseAccount = accountService.decreaseAccount(accountInfo);
		if(createOrder && decreaseAccount) {
			return true;
		}
		return false;
	}

	public Boolean confirmBusiness(BusinessRequest businessRequest) {
		logger.info("===进入confirm节点business===");
		OrderRequest orderRequest = businessRequest.getOrderRequest();
		AccountRequest accountRequest = businessRequest.getAccountRequest();
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setDeleted(0);
		BeanUtils.copyProperties(orderRequest, orderInfo);
		Boolean createOrder = orderInfoService.createOrder(orderInfo);
		AccountInfo accountInfo = new AccountInfo();
		BeanUtils.copyProperties(accountRequest, accountInfo);
		accountInfo.setDeleted(0);
		Boolean decreaseAccount = accountService.decreaseAccount(accountInfo);
		if(createOrder && decreaseAccount) {
			return true;
		}
		return false;
	}
	
	public Boolean cancelBusiness(BusinessRequest businessRequest) {
		logger.info("===进入cancel节点business===");
		OrderRequest orderRequest = businessRequest.getOrderRequest();
		AccountRequest accountRequest = businessRequest.getAccountRequest();
		OrderInfo orderInfo = new OrderInfo();
		orderInfo.setDeleted(1);
		BeanUtils.copyProperties(orderRequest, orderInfo);
		Boolean createOrder = orderInfoService.createOrder(orderInfo);
		AccountInfo accountInfo = new AccountInfo();
		BeanUtils.copyProperties(accountRequest, accountInfo);
		Boolean decreaseAccount = accountService.decreaseAccount(accountInfo);
		if(createOrder && decreaseAccount) {
			return true;
		}
		return false;
	}
}

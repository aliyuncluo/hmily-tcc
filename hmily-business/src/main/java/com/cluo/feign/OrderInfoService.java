package com.cluo.feign;

import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cluo.pojo.OrderInfo;

@FeignClient("hmily-order")
public interface OrderInfoService {

	@PostMapping("/order/create")
	@Hmily
	public Boolean createOrder(@RequestBody OrderInfo orderInfo); 
}

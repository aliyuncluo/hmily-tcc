package com.cluo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cluo.pojo.OrderInfo;
import com.cluo.response.OrderResponse;
import com.cluo.service.OrderInfoService;

@RestController
public class OrderInfoController {

	@Autowired
	private OrderInfoService orderInfoService;
	
	@PostMapping("/order/create")
	public Boolean createOrder(@RequestBody OrderInfo orderInfo) {
		return orderInfoService.createOrder(orderInfo);
	}
}

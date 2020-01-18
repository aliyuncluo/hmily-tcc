package com.cluo.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cluo.request.BusinessRequest;
import com.cluo.service.BusinessService;

@RestController
public class BusinessController {
    @Autowired
	private BusinessService businessService;
	
	@PostMapping("/test/shop")
	public Boolean doBusiness(@RequestBody BusinessRequest businessRequest){
		return businessService.doBusiness(businessRequest);
	}
}

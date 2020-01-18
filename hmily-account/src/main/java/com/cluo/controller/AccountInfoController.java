package com.cluo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cluo.pojo.AccountInfo;
import com.cluo.response.AccountResponse;
import com.cluo.service.AccountInfoService;

@RestController
public class AccountInfoController {

	@Autowired
	private AccountInfoService accountInfoService;
	
	@PostMapping("/account/decrease")
	public Boolean decreaseAccount(@RequestBody AccountInfo accountInfo) {
		try {
			Thread.sleep(50000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return accountInfoService.decreaseAccount(accountInfo);
	}
}

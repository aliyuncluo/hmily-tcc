package com.cluo.feign;

import org.dromara.hmily.annotation.Hmily;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cluo.pojo.AccountInfo;

@FeignClient("hmily-account")
public interface AccountService {

	@PostMapping("/account/decrease")
	@Hmily
	public Boolean decreaseAccount(@RequestBody AccountInfo accountInfo);
}

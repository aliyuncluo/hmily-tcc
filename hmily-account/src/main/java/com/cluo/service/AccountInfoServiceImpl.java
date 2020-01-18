package com.cluo.service;

import org.dromara.hmily.annotation.Hmily;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cluo.mapper.AccountInfoMapper;
import com.cluo.pojo.AccountInfo;
import com.cluo.response.AccountResponse;

@Service
public class AccountInfoServiceImpl implements AccountInfoService{
    private Logger logger = LoggerFactory.getLogger(AccountInfoServiceImpl.class);
	@Autowired
	private AccountInfoMapper accountInfoMapper;
	
	@Hmily(confirmMethod="confirmDecrease",cancelMethod="cancelDecrease")
	@Override
	public Boolean decreaseAccount(AccountInfo accountInfo) {
		logger.info("===执行try扣减账户金额操作===");
		accountInfo.setDeleted(null);
		int tryDecrease = accountInfoMapper.tryDecrease(accountInfo);
		return true;
	}

	
	public Boolean confirmDecrease(AccountInfo accountInfo) {
		logger.info("===执行confirm扣减账户金额操作===");
		accountInfo.setDeleted(0);//可用
		int confirmDecrease = accountInfoMapper.confirmDecrease(accountInfo);
		return true;
		
	}
	
	public Boolean cancelDecrease(AccountInfo accountInfo) {
		logger.info("===执行cancel扣减账户金额操作===");
		try {
			accountInfo.setDeleted(0);//可用
			int cancelDecrease = accountInfoMapper.cancelDecrease(accountInfo);
			return true;
		} catch (Exception e) {
			throw new RuntimeException("扣减账户余额失败");
		}
	}
}

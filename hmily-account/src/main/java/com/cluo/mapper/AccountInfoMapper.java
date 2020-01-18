package com.cluo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import com.cluo.pojo.AccountInfo;

@Mapper
public interface AccountInfoMapper {

	@Update({"update hmily_account set acct_bal=acct_bal-#{acctBal},fronze = fronze+#{acctBal},"
			+ "update_time=now(),deleted=#{deleted} where acct_no=#{acctNo}"})
	public int tryDecrease(AccountInfo accountInfo);
	
	@Update({"update hmily_account set fronze = fronze-#{acctBal},update_time=now(),deleted=#{deleted} where acct_no=#{acctNo}"})
	public int confirmDecrease(AccountInfo accountInfo);
	
	@Update({"update hmily_account set acct_bal=acct_bal+#{acctBal},fronze = fronze-#{acctBal},"
			+ "update_time=now(),deleted=#{deleted} where acct_no=#{acctNo}"})
	public int cancelDecrease(AccountInfo accountInfo);
}

package com.cluo.response;

public class AccountResponse {


	private String code;
	
	private String message;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public AccountResponse() {}
	public AccountResponse(String code,String message) {
		this.code = code;
		this.message = message;
	}
	
	public static AccountResponse getInstance() {
		return new AccountResponse();
	}
	
	public AccountResponse success() {
		AccountResponse response = getInstance();
		response.setCode("200");
		response.setMessage("账户操作成功");
		return response;
	}
	
	public AccountResponse failure() {
		AccountResponse response = getInstance();
		response.setCode("500");
		response.setMessage("账户操作失败");
		return response;
	}
}

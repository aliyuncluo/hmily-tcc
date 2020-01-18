package com.cluo.response;

import lombok.Data;


public class OrderResponse {

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
	
	public OrderResponse() {}
	public OrderResponse(String code,String message) {
		this.code = code;
		this.message = message;
	}
	
	public static OrderResponse getInstance() {
		return new OrderResponse();
	}
	
	public OrderResponse success() {
		OrderResponse response = getInstance();
		response.setCode("200");
		response.setMessage("订单操作成功");
		return response;
	}
	
	public OrderResponse failure() {
		OrderResponse response = getInstance();
		response.setCode("500");
		response.setMessage("订单操作失败");
		return response;
	}
}

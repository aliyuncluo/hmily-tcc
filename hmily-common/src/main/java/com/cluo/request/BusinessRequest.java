package com.cluo.request;

public class BusinessRequest {

	private OrderRequest orderRequest;
	
	private AccountRequest accountRequest;

	public OrderRequest getOrderRequest() {
		return orderRequest;
	}

	public void setOrderRequest(OrderRequest orderRequest) {
		this.orderRequest = orderRequest;
	}

	public AccountRequest getAccountRequest() {
		return accountRequest;
	}

	public void setAccountRequest(AccountRequest accountRequest) {
		this.accountRequest = accountRequest;
	}
	
	
}

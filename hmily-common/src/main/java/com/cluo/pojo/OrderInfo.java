package com.cluo.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

import lombok.Data;

public class OrderInfo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8693794382081872621L;
	/**id*/
	private Long id;
	/**订单编号*/
	private String orderNo;
	/**商品名称*/
	private String productName;
	/**商品数量*/
	private Integer productNum;
	/**商品单价*/
	private BigDecimal unitPrice;
	/**商品总金额*/
	private BigDecimal total;
	/**是否删除 0否 1是*/
	private Integer deleted;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductNum() {
		return productNum;
	}
	public void setProductNum(Integer productNum) {
		this.productNum = productNum;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	
	
}

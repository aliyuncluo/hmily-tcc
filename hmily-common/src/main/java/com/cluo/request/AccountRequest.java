package com.cluo.request;

import java.math.BigDecimal;
import java.util.Date;

public class AccountRequest {

	/**id*/
	private Long id;
	/**账户编号*/
	private String acctNo;
	/**账户名称*/
	private String acctName;
	/**账户余额*/
	private BigDecimal acctBal;
	/**冻结金额*/
	private BigDecimal fronze;
	/**变更时间*/
	private Date updateTime;
	/**是否删除 0否 1是*/
	private Integer deleted;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAcctNo() {
		return acctNo;
	}
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	public String getAcctName() {
		return acctName;
	}
	public void setAcctName(String acctName) {
		this.acctName = acctName;
	}
	public BigDecimal getAcctBal() {
		return acctBal;
	}
	public void setAcctBal(BigDecimal acctBal) {
		this.acctBal = acctBal;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public Integer getDeleted() {
		return deleted;
	}
	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}
	public BigDecimal getFronze() {
		return fronze;
	}
	public void setFronze(BigDecimal fronze) {
		this.fronze = fronze;
	}
	
	
}

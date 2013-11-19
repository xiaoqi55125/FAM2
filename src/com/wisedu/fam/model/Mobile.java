package com.wisedu.fam.model;

import java.math.BigDecimal;

/**
 * 移动设备实体类
 * @author zhicheng
 *
 */
public class Mobile {
	private String newId;
	private String deviceName;
	private String type;
	private String configure;
	private java.math.BigDecimal price;
	private String purpose;
	private String remark;
	public Mobile(String newId, String deviceName, String type,
			String configure, BigDecimal price, String purpose, String remark) {
		super();
		this.newId = newId;
		this.deviceName = deviceName;
		this.type = type;
		this.configure = configure;
		this.price = price;
		this.purpose = purpose;
		this.remark = remark;
	}
	public Mobile() {
		super();
	}
	public String getNewId() {
		return newId;
	}
	public void setNewId(String newId) {
		this.newId = newId;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getConfigure() {
		return configure;
	}
	public void setConfigure(String configure) {
		this.configure = configure;
	}
	public java.math.BigDecimal getPrice() {
		return price;
	}
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	

}

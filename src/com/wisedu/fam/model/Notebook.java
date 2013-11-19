package com.wisedu.fam.model;

import java.math.BigDecimal;

/**
 * 笔记本实体类
 * @author zhicheng
 *
 */
public class Notebook {
	private String newId;
	private String type;
	private String cpu;
	private String ram;
	private String hd;
	private java.math.BigDecimal price;
	private String purpose;
	private String serviceCode;
	private String remark;
	private String mac1;
	private String mac2;
	public Notebook(String newId, String type, String cpu, String ram,
			String hd, BigDecimal price, String purpose, String serviceCode,
			String remark, String mac1, String mac2) {
		super();
		this.newId = newId;
		this.type = type;
		this.cpu = cpu;
		this.ram = ram;
		this.hd = hd;
		this.price = price;
		this.purpose = purpose;
		this.serviceCode = serviceCode;
		this.remark = remark;
		this.mac1 = mac1;
		this.mac2 = mac2;
	}
	public Notebook() {
		super();
	}
	public String getNewId() {
		return newId;
	}
	public void setNewId(String newId) {
		this.newId = newId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getHd() {
		return hd;
	}
	public void setHd(String hd) {
		this.hd = hd;
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
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getMac1() {
		return mac1;
	}
	public void setMac1(String mac1) {
		this.mac1 = mac1;
	}
	public String getMac2() {
		return mac2;
	}
	public void setMac2(String mac2) {
		this.mac2 = mac2;
	}
	
}

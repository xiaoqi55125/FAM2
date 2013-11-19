package com.wisedu.fam.model;
/**
 * 显示器实体类
 * @author zhicheng
 *
 */
public class Monitor {
	private String newId;
	private String brand;
	private String size;
	private String screenType;
	private String purpose;
	private String position;
	private String remark;
	public Monitor(String newId, String brand, String size, String screenType,
			String purpose, String position, String remark) {
		super();
		this.newId = newId;
		this.brand = brand;
		this.size = size;
		this.screenType = screenType;
		this.purpose = purpose;
		this.position = position;
		this.remark = remark;
	}
	public Monitor() {
		super();
	}
	public String getNewId() {
		return newId;
	}
	public void setNewId(String newId) {
		this.newId = newId;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getScreenType() {
		return screenType;
	}
	public void setScreenType(String screenType) {
		this.screenType = screenType;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}

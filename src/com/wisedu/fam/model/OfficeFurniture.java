package com.wisedu.fam.model;

import java.math.BigDecimal;

/**
 * 办公家具实体类
 * @author zhicheng
 *
 */
public class OfficeFurniture {
	private String newId;
	private String furnitureName;
	private int amount;
	private BigDecimal price;
	private String position;
	private String supplier;
	private String remark;
	public OfficeFurniture(String newId, String furnitureName, int amount,
			BigDecimal price, String position, String supplier, String remark) {
		super();
		this.newId = newId;
		this.furnitureName = furnitureName;
		this.amount = amount;
		this.price = price;
		this.position = position;
		this.supplier = supplier;
		this.remark = remark;
	}
	public OfficeFurniture() {
		super();
	}
	public String getNewId() {
		return newId;
	}
	public void setNewId(String newId) {
		this.newId = newId;
	}
	public String getFurnitureName() {
		return furnitureName;
	}
	public void setFurnitureName(String furnitureName) {
		this.furnitureName = furnitureName;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}

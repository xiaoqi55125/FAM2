package com.wisedu.fam.model;

import java.math.BigDecimal;

/**
 * 办公设备实体类
 * 
 * @author zhicheng
 * 
 */
public class OfficeEquipment {
	private String newId;
	private String equipmentName;
	private BigDecimal price;
	private String puroise;
	private String position;
	private String supplier;
	private String remark;
	public OfficeEquipment(String newId, String equipmentName,
			BigDecimal price, String puroise, String position, String supplier,
			String remark) {
		super();
		this.newId = newId;
		this.equipmentName = equipmentName;
		this.price = price;
		this.puroise = puroise;
		this.position = position;
		this.supplier = supplier;
		this.remark = remark;
	}
	public OfficeEquipment() {
		super();
	}
	public String getNewId() {
		return newId;
	}
	public void setNewId(String newId) {
		this.newId = newId;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getPuroise() {
		return puroise;
	}
	public void setPuroise(String puroise) {
		this.puroise = puroise;
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

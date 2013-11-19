package com.wisedu.fam.model;

import java.math.BigDecimal;

/**
 * 虚拟设备实体类
 * 
 * @author zhicheng
 * 
 */
public class VirtualEquipment {
	private String newId;
	private String equipmentName;
	private String supplier;
	private BigDecimal price;
	private String remark;

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

	public String getSupplier() {
		return supplier;
	}

	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public VirtualEquipment(String newId, String equipmentName,
			String supplier, BigDecimal price, String remark) {
		super();
		this.newId = newId;
		this.equipmentName = equipmentName;
		this.supplier = supplier;
		this.price = price;
		this.remark = remark;
	}

	public VirtualEquipment() {
		super();
	}

}

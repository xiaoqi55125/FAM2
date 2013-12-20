package com.wisedu.fam.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Assets entity
 * 
 * @author zhicheng@mail.com
 * 
 */
public class Assets implements Serializable {
	private String newId;
	private String oldId;
	private String userId;
	private String departmentId;
	private int typeId;
	private String assetName;
	private String assetBelong;
	private String currentStatus;
	private String brand;
	private String model;
	private String specifications;
	private BigDecimal price;
	private String purchaseDate;
	private String possessDate;
	private String serviceCode;
	private String mac;
	private int reject;
	private String rejectDate;
	private String remark1;
	private String remark2;
	private String qrcode;
	private int companyId;
	public Assets(String newId, String oldId, String userId,
			String departmentId, int typeId, String assetName,
			String assetBelong, String currentStatus, String brand,
			String model, String specifications, BigDecimal price,
			String purchaseDate, String possessDate, String serviceCode,
			String mac, int reject, String rejectDate, String remark1,
			String remark2, String qrcode, int companyId) {
		super();
		this.newId = newId;
		this.oldId = oldId;
		this.userId = userId;
		this.departmentId = departmentId;
		this.typeId = typeId;
		this.assetName = assetName;
		this.assetBelong = assetBelong;
		this.currentStatus = currentStatus;
		this.brand = brand;
		this.model = model;
		this.specifications = specifications;
		this.price = price;
		this.purchaseDate = purchaseDate;
		this.possessDate = possessDate;
		this.serviceCode = serviceCode;
		this.mac = mac;
		this.reject = reject;
		this.rejectDate = rejectDate;
		this.remark1 = remark1;
		this.remark2 = remark2;
		this.qrcode = qrcode;
		this.companyId = companyId;
	}
	public Assets() {
		super();
	}
	public String getNewId() {
		return newId;
	}
	public void setNewId(String newId) {
		this.newId = newId;
	}
	public String getOldId() {
		return oldId;
	}
	public void setOldId(String oldId) {
		this.oldId = oldId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getAssetName() {
		return assetName;
	}
	public void setAssetName(String assetName) {
		this.assetName = assetName;
	}
	public String getAssetBelong() {
		return assetBelong;
	}
	public void setAssetBelong(String assetBelong) {
		this.assetBelong = assetBelong;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getSpecifications() {
		return specifications;
	}
	public void setSpecifications(String specifications) {
		this.specifications = specifications;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getPossessDate() {
		return possessDate;
	}
	public void setPossessDate(String possessDate) {
		this.possessDate = possessDate;
	}
	public String getServiceCode() {
		return serviceCode;
	}
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public int getReject() {
		return reject;
	}
	public void setReject(int reject) {
		this.reject = reject;
	}
	public String getRejectDate() {
		return rejectDate;
	}
	public void setRejectDate(String rejectDate) {
		this.rejectDate = rejectDate;
	}
	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	public String getRemark2() {
		return remark2;
	}
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	public String getQrcode() {
		return qrcode;
	}
	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}
	public int getCompanyId() {
		return companyId;
	}
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	
}

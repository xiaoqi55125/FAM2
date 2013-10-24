package com.wisedu.fam.model;
import java.util.Date;
/**
 * Equipment entity
 * @author zhicheng
 *
 */
public class Equipment
{
    private java.util.Date rejectDate;
    private int reject;
    private Date possessDate;
    private Date purchaseDate;
    private String lastUserId;
    private String equipmentSqlName;
    private String equipmentName;
    private String equipmentId;
    
	public java.util.Date getRejectDate() {
		return rejectDate;
	}
	public void setRejectDate(java.util.Date rejectDate) {
		this.rejectDate = rejectDate;
	}
	public int getReject() {
		return reject;
	}
	public void setReject(int reject) {
		this.reject = reject;
	}
	public Date getPossessDate() {
		return possessDate;
	}
	public void setPossessDate(Date possessDate) {
		this.possessDate = possessDate;
	}
	public Date getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public String getLastUserId() {
		return lastUserId;
	}
	public void setLastUserId(String lastUserId) {
		this.lastUserId = lastUserId;
	}
	public String getEquipmentSqlName() {
		return equipmentSqlName;
	}
	public void setEquipmentSqlName(String equipmentSqlName) {
		this.equipmentSqlName = equipmentSqlName;
	}
	public String getEquipmentName() {
		return equipmentName;
	}
	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}
	public String getEquipmentId() {
		return equipmentId;
	}
	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}
	public Equipment(Date rejectDate, int reject, Date possessDate,
			Date purchaseDate, String lastUserId, String equipmentSqlName,
			String equipmentName, String equipmentId) {
		super();
		this.rejectDate = rejectDate;
		this.reject = reject;
		this.possessDate = possessDate;
		this.purchaseDate = purchaseDate;
		this.lastUserId = lastUserId;
		this.equipmentSqlName = equipmentSqlName;
		this.equipmentName = equipmentName;
		this.equipmentId = equipmentId;
	}
	public Equipment() {
		super();
	}
    
	
    
}

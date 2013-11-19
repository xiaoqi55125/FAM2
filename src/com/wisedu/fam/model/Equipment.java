package com.wisedu.fam.model;
/**
 * Equipment entity
 * @author zhicheng
 *
 */
public class Equipment
{
    private String rejectDate;
    private int reject;
    private String possessDate;
    private String purchaseDate;
    private String lastUserId;
    private String equipmentSqlName;
    private String equipmentName;
    private String equipmentId;
    
	public String getRejectDate() {
		return rejectDate;
	}
	public void setRejectDate(String rejectDate) {
		this.rejectDate = rejectDate;
	}
	public int getReject() {
		return reject;
	}
	public void setReject(int reject) {
		this.reject = reject;
	}
	public String getPossessDate() {
		return possessDate;
	}
	public void setPossessDate(String possessDate) {
		this.possessDate = possessDate;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(String purchaseDate) {
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
	public Equipment(String rejectDate, int reject, String possessDate,
			String purchaseDate, String lastUserId, String equipmentSqlName,
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

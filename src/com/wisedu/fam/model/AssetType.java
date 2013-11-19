package com.wisedu.fam.model;

/**
 * 设备类型表实体
 * @author zhicheng
 *
 */
public class AssetType {
	private int typeId;
	private String typeName;
	public AssetType(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}
	public AssetType() {
		super();
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}

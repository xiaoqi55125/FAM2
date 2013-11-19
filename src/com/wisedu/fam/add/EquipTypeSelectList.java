package com.wisedu.fam.add;

public class EquipTypeSelectList {
	private String typeId;
	private String typeName;
	private String typeImage;
	public String getTypeId() {
		return typeId;
	}
	public String getTypeName() {
		return typeName;
	}
	public String getTypeImage() {
		return typeImage;
	}
	public EquipTypeSelectList(String typeId, String typeName, String typeImage) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.typeImage = typeImage;
	}
	
}

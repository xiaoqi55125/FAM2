package com.wisedu.fam.check;

public class AssetOneList {
	
	private String textID;
	private String valueString;
	public String getTextID() {
		return textID;
	}
	public void setTextID(String textID) {
		this.textID = textID;
	}
	public String getValueString() {
		return valueString;
	}
	public void setValueString(String valueString) {
		this.valueString = valueString;
	}
	public AssetOneList(String textID, String valueString) {
		super();
		this.textID = textID;
		this.valueString = valueString;
	}
	public AssetOneList() {
		super();
	}
	
    
}

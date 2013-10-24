package com.wisedu.fam.help;

import android.R.string;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.wisedu.fam.model.Equipment;
import com.wisedu.fam.model.HostComputer;

public class EquipHelper {
	
	public static String checkType(String name,JsonObject jsonObject){
		Gson gson = new Gson();
		String tempString = "";
		switch (Eqiup.toEqiup(name.toUpperCase())) {
		case HOSTCOMPUTER:
			HostComputer hostComputer = gson.fromJson(jsonObject, HostComputer.class);
			if (hostComputer.getBrand()!=null) {
				tempString +="品 牌:"+hostComputer.getBrand()+"<p>";
			}
			if (hostComputer.getCpu()!=null) {
				tempString +="CPU类型:"+hostComputer.getCpu()+"<p>";
			}
			if (hostComputer.getCpuFrequency()!=null) {
				tempString +="CPU频率:"+hostComputer.getCpuFrequency()+"<p>";
			}
			if (hostComputer.getRam()!=null) {
				tempString +="内存:"+hostComputer.getRam()+"<p>";
			}
			if (hostComputer.getHd()!=null) {
				tempString +="硬盘:"+hostComputer.getHd()+"<p>";
			}
			if (hostComputer.getMac()!=null) {
				tempString +="Mac地址:"+hostComputer.getMac()+"<p>";
			}
			if (hostComputer.getPrice()!=null) {
				tempString +="价格:"+hostComputer.getPrice()+"<p>";
			}
			if (hostComputer.getPurpose()!=null) {
				tempString +="用途:"+hostComputer.getPurpose()+"<p>";
			}
			if (hostComputer.getPosition()!=null) {
				tempString +="<p>位置:"+hostComputer.getPosition()+"</p>";
			}
			if (hostComputer.getRemark()!=null) {
				tempString +="<p>备注:"+hostComputer.getRemark()+"</p>";
			}
			return tempString;
		default:
			break;
		}
		
		return null;
	}
	public enum Eqiup{
		HOSTCOMPUTER, MOBILE, MONITOR, NOTEBOOK,
		OFFICEEQUIPMENT, OFFICEFURNITURE, OTHEREQUIPMENT,
		SERVER,VIRTUALEQUIPMENT;
	public static Eqiup toEqiup(String str){
		try {
		return valueOf(str);
		}
		catch (Exception ex) {
			return OTHEREQUIPMENT;
		}
		}
	}
	public static String equipString(Equipment equipment,String huan){
		String tempString = "";
		if (equipment.getEquipmentId()!=null) {
			tempString+="设备号:"+equipment.getEquipmentId()+"<"+huan+">";
		}
		if (equipment.getEquipmentName()!=null) {
			tempString+="设备名:"+equipment.getEquipmentName()+"<"+huan+">";
		}
		if (equipment.getPurchaseDate()!=null) {
			tempString+="购买日期:"+equipment.getPurchaseDate()+"<"+huan+">";
		}
		if (equipment.getPossessDate()!=null) {
			tempString+="领用日期:"+equipment.getPossessDate()+"<"+huan+">";
		}
		if (equipment.getReject()>0) {
			if (equipment.getReject()==1) {
				tempString+="报销情况:已报销"+"<"+huan+">";	
				if (equipment.getRejectDate()!=null) {
					tempString+="报销日期:"+equipment.getRejectDate()+"<"+huan+">";
				}
			}
		}
		return tempString;
	}

}

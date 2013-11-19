package com.wisedu.fam.help;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.wisedu.fam.model.AssetType;
import com.wisedu.fam.model.Assets;
import com.wisedu.fam.model.Department;
import com.wisedu.fam.model.Equipment;
import com.wisedu.fam.model.User;

public class EquipHelper {
	/**
	 * 根据二维码查询,呈现的文本
	 * @param assets 资产实体
	 * @param user 用户实体
	 * @param department 部门实体
	 * @param assetType 资产类型实体
	 * @return 文本
	 */
	public static String assetDetailsFromQrcode(Assets assets,User user,Department department,AssetType assetType) {
		String temp = "";
		if (checkNull(assets.getNewId())) {
			temp+="设备号:"+assets.getNewId()+"<p>";
		}
		if (checkNull(assets.getOldId())) {
			temp+="旧设备号:"+assets.getOldId()+"<p>";
		}
		if (checkNull(assets.getUserId())) {
			temp+="归属人:"+user.getUserName()+"<p>";
		}
		if (checkNull(assets.getDepartmentId())) {
			temp+="资产所属部门:"+department.getDepartmentName()+"<p>";
		}
		if (checkNull(assets.getTypeId()+"")) {
			//需处理
			if(assetType.getTypeName()!=assets.getAssetName())
				temp+="设备类型:"+assets.getAssetName()+"<p>";
			else
				temp+="设备类型:"+assetType.getTypeName()+"<p>";
		}
		if (checkNull(assets.getAssetBelong())) {
			temp+="设备归属:"+assets.getAssetBelong()+"<p>";
		}
		if (checkNull(assets.getCurrentStatus())) {
			temp+="当前状态:"+assets.getCurrentStatus()+"<p>";
		}
		if (checkNull(assets.getBrand())) {
			temp+="品牌:"+assets.getBrand()+"<p>";
		}
		if (checkNull(assets.getModel())) {
			temp+="型号:"+assets.getModel()+"<p>";
		}
		if (checkNull(assets.getSpecifications())) {
			temp+="规格:"+assets.getSpecifications()+"<p>";
		}
		if (checkNull(assets.getAmount()+"")) {
			temp+="数量:"+assets.getAmount()+"<p>";
		}
		if (checkNull(assets.getPrice()+"")) {
			temp+="金额:"+assets.getPrice()+"<p>";
		}
		if (checkNull(assets.getPurchaseDate())) {
			temp+="购置日期:"+assets.getPurchaseDate()+"<p>";
		}
		if (checkNull(assets.getPossessDate())) {
			temp+="领用日期:"+assets.getPossessDate()+"<p>";
		}
		if (checkNull(assets.getServiceCode())) {
			temp+="快速服务代码:"+assets.getServiceCode()+"<p>";
		}
		if (checkNull(assets.getMac())) {
			temp+="MAC地址:"+assets.getMac()+"<p>";
		}
		if (checkNull(assets.getRemark1())) {
			temp+="备注1:"+assets.getRemark1()+"<p>";
		}
		if (checkNull(assets.getRemark2())) {
			temp+="备注2:"+assets.getRemark2()+"<p>";
		}
		return temp;
	}

	/**
	 * 设备总表数据 用户名下
	 * 
	 * @param equipment
	 * @param huan
	 * @return
	 */
	public static String equipStringUnderName(Assets asset, String huan) {
		String tempString = "";
		if (EquipHelper.checkNull(asset.getNewId())) {
			tempString += "设备号:" + asset.getNewId() + "<" + huan
					+ ">";
		}
		if (EquipHelper.checkNull(asset.getAssetName())) {
			tempString += "设备名:" + asset.getAssetName() + "<" + huan
					+ ">";
		}
		return tempString;
	}

	/**
	 * 设备总表数据 带日期
	 * 
	 * @param equipment
	 * @param huan
	 * @return
	 */
	public static String equipString(Equipment equipment, String huan) {
		String tempString = "";
		if (EquipHelper.checkNull(equipment.getEquipmentId())) {
			tempString += "设备号:" + equipment.getEquipmentId() + "<" + huan
					+ ">";
		}
		if (EquipHelper.checkNull(equipment.getEquipmentName())) {
			tempString += "设备名:" + equipment.getEquipmentName() + "<" + huan
					+ ">";
		}
		if (EquipHelper.checkNull(equipment.getPurchaseDate())) {
			tempString += "购买日期:" + dateAnalyser(equipment.getPurchaseDate())
					+ "<" + huan + ">";
		}
		if (checkNull(dateAnalyser(equipment.getPossessDate()))) {
			tempString += "领用日期:" + dateAnalyser(equipment.getPossessDate())
					+ "<" + huan + ">";
		}
		if (equipment.getReject() > 0) {
			if (equipment.getReject() == 1) {
				tempString += "报废情况:已报废" + "<" + huan + ">";
				if (equipment.getRejectDate() != null) {
					tempString += "报销日期:"
							+ dateAnalyser(equipment.getRejectDate()) + "<"
							+ huan + ">";
				}
			}
		}
		return tempString;
	}

	/**
	 * 返回用户信息
	 * 
	 * @param user
	 *            用户对象
	 * @return 用户信息文本
	 */
	public static String userInfo(User user) {
		String tempString = "";
		if (checkNull(user.getUserName())) {
			tempString += "<p>领用人:" + user.getUserName() + "</p>";
		}
		if (checkNull(user.getUserId())) {
			tempString += "<p>工 号:" + user.getUserId() + "</p>";
		}
		if (checkNull(user.getPhone())) {
			tempString += "<p>电 话:" + user.getPhone() + "</p>";
		}
		if (checkNull(user.getMail())) {
			tempString += "<p>邮 箱:" + user.getMail() + "</p>";
		}
		if (checkNull(user.getDepartment())) {
			tempString += "部 门:" + "<br>"
					+ user.getDepartment().replace("@", "<br>") + "<br>";
		}
		return tempString;
	}

	/**
	 * check null about
	 * 
	 * @param name
	 * @return
	 */
	public static boolean checkNull(String name) {
		if (name != null && !name.equals("") && name.length() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * idGenerator
	 * 
	 * @param typeId
	 * @return
	 */
	public static String idGenerator(String typeId) {
		String temp = "";
		temp += typeId;
		Date curDate = new Date(System.currentTimeMillis());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"yyyyMMddHHmmss");
		temp = temp + simpleDateFormat.format(curDate);
		return temp;
	}
	/**
	 * 暂时弃用
	 * @param dateString
	 * @return
	 */
	public static String dateAnalyser(String dateString) {
		String temp = "";
		if (dateString.indexOf("0000") != -1) {
			temp = "";
		} else {
			temp = dateString.substring(0, 10);
		}
		return temp;
	}
}

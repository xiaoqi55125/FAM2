package com.wisedu.fam.model;

import java.math.BigDecimal;

/**
 * 服务器实体类
 * 
 * @author zhicheng
 * 
 */
public class Server {
	private String newId;
	private String purpose;
	private String brand;
	private String cpu;
	private String cpuFrequency;
	private String ram;
	private String ramSize;
	private String ramFrequency;
	private String hd;
	private BigDecimal price;
	private String liable;
	private String position;
	private String mac;
	private String ipRange;
	private String remark;

	public Server(String newId, String purpose, String brand, String cpu,
			String cpuFrequency, String ram, String ramSize,
			String ramFrequency, String hd, BigDecimal price, String liable,
			String position, String mac, String ipRange, String remark) {
		super();
		this.newId = newId;
		this.purpose = purpose;
		this.brand = brand;
		this.cpu = cpu;
		this.cpuFrequency = cpuFrequency;
		this.ram = ram;
		this.ramSize = ramSize;
		this.ramFrequency = ramFrequency;
		this.hd = hd;
		this.price = price;
		this.liable = liable;
		this.position = position;
		this.mac = mac;
		this.ipRange = ipRange;
		this.remark = remark;
	}

	public Server() {
		super();
	}

	public String getNewId() {
		return newId;
	}

	public void setNewId(String newId) {
		this.newId = newId;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public String getCpuFrequency() {
		return cpuFrequency;
	}

	public void setCpuFrequency(String cpuFrequency) {
		this.cpuFrequency = cpuFrequency;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getRamSize() {
		return ramSize;
	}

	public void setRamSize(String ramSize) {
		this.ramSize = ramSize;
	}

	public String getRamFrequency() {
		return ramFrequency;
	}

	public void setRamFrequency(String ramFrequency) {
		this.ramFrequency = ramFrequency;
	}

	public String getHd() {
		return hd;
	}

	public void setHd(String hd) {
		this.hd = hd;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getLiable() {
		return liable;
	}

	public void setLiable(String liable) {
		this.liable = liable;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getIpRange() {
		return ipRange;
	}

	public void setIpRange(String ipRange) {
		this.ipRange = ipRange;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}

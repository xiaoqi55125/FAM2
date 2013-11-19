package com.wisedu.fam.model;

import java.math.BigDecimal;
/**
 * 主机实体类
 * @author zhicheng
 *
 */
public class HostComputer {
    
	private String remark;
    private String position;
    private String purpose;
    private java.math.BigDecimal price;
    private String mac;
    private String hd;
    private String ram;
    private String cpuFrequency;
    private String cpu;
    private String brand;
    private String oldId;
    private String newId;
    
	
    public HostComputer() {
		super();
	}
	public HostComputer(String remark, String position, String purpose,
			BigDecimal price, String mac, String hd, String ram,
			String cpuFrequency, String cpu, String brand, String oldId,
			String newId) {
		super();
		this.remark = remark;
		this.position = position;
		this.purpose = purpose;
		this.price = price;
		this.mac = mac;
		this.hd = hd;
		this.ram = ram;
		this.cpuFrequency = cpuFrequency;
		this.cpu = cpu;
		this.brand = brand;
		this.oldId = oldId;
		this.newId = newId;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getPurpose() {
		return purpose;
	}
	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}
	public java.math.BigDecimal getPrice() {
		return price;
	}
	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getHd() {
		return hd;
	}
	public void setHd(String hd) {
		this.hd = hd;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getCpuFrequency() {
		return cpuFrequency;
	}
	public void setCpuFrequency(String cpuFrequency) {
		this.cpuFrequency = cpuFrequency;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getoldId() {
		return oldId;
	}
	public void setoldId(String oldId) {
		this.oldId = oldId;
	}
	public String getnewId() {
		return newId;
	}
	public void setnewId(String newId) {
		this.newId = newId;
	}

}

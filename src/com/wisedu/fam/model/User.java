package com.wisedu.fam.model;

public class User {
    private String mail;
    private String phone;
    private String department;
    private String userName;
    private String userId;
    
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public User(String mail, String phone, String department, String userName,
			String userId) {
		super();
		this.mail = mail;
		this.phone = phone;
		this.department = department;
		this.userName = userName;
		this.userId = userId;
	}
	public User() {
		super();
	}
    
}

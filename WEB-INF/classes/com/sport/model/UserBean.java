package com.sport.model;

public class UserBean {

	int userid;
	String no_matric;
	String fullname;
	String email;
	String no_phone;
	String password;


	

	public UserBean(int userid, String no_matric, String fullname, String email, String no_phone, String password) {
		
		this.userid = userid;
		this.no_matric = no_matric;
		this.fullname = fullname;
		this.email = email;
		this.no_phone = no_phone;
		this.password = password;
	}

	public UserBean() {
		// TODO Auto-generated constructor stub
		 userid=0;
		 no_matric="";
		 fullname="";
		 email="";
		 no_phone="";
		 password="";
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getNo_matric() {
		return no_matric;
	}

	public void setNo_matric(String no_matric) {
		this.no_matric = no_matric;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNo_phone() {
		return no_phone;
	}

	public void setNo_phone(String no_phone) {
		this.no_phone = no_phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
	
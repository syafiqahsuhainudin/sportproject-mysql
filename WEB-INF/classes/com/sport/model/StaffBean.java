package com.sport.model;

import java.io.IOException;
import java.io.Serializable;



public class StaffBean implements Serializable{
	private int id;

	private String staff_id;
	private String staff_name;
	private String staff_phone; 
	private String staff_email; 
	private String staff_password;
	
	public StaffBean(int id,String staff_id, String staff_name, String staff_phone, String staff_email, String staff_password) {
		this.staff_id=staff_id;
		this.id=id;
		this.staff_name=staff_name;
		this.staff_phone=staff_phone;
		this.staff_email=staff_email;
		this.staff_password=staff_password;
	}
	public StaffBean() {
		id=0;
		staff_id="";
		staff_name="";
		staff_phone="";
		staff_email="";
		staff_password="";
	}
	public String getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(String staff_id) {
		this.staff_id=staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}  
	public void setStaff_name(String staff_name) {
		this.staff_name=staff_name;
	}
	public String getStaff_phone() {
		return staff_phone;
	}
	public void setStaff_phone(String staff_phone) {
		this.staff_phone=staff_phone;
	}
	public String getStaff_email() {
		return staff_email;
	}
	public void setStaff_email(String staff_email) {
		this.staff_email=staff_email;
	}
	public String getStaff_password() {
		return staff_password;
	}
	public void setStaff_password(String staff_password) {
		this.staff_password = staff_password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "StaffBean [staff_id=" + staff_id + ", staff_name=" + staff_name + ", staff_phone=" + staff_phone
				+ ", staff_email=" + staff_email + ", staff_password=" + staff_password + "]";
	}
}
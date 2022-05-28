package com.sport.model;

import java.io.Serializable;
import java.sql.Date;
import com.sport.model.EquipmentBean;
import com.sport.model.UserBean;

public class BookingBean implements Serializable {

	private int booking_id;
	private int quantity;
	private String date;
	private String statusbook;
	private EquipmentBean equipmentBean;
	private UserBean userBean;
	
	private String matric_no;
	private String equip_namesB;
	private String year;
	private String weekof;

	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getWeek() {
		return week;
	}
	public void setWeek(String week) {
		this.week = week;
	}
	private String week;

	private int equip_quan;
	public BookingBean(int booking_id, int quantity, String date, String statusbook, EquipmentBean equipmentBean,UserBean userBean) {
	
		this.booking_id = booking_id;
		this.quantity = quantity;
		this.date = date;
		this.statusbook = statusbook;
		this.equipmentBean = equipmentBean;
		this.userBean = userBean;
	}
	public BookingBean() {
		booking_id=0;
		quantity=0;
		date="";
		statusbook="";
		equipmentBean=getEquipmentBean();
		userBean=getUserBean();
		// TODO Auto-generated constructor stub
	}
	public int getBooking_id() {
		return booking_id;
	}
	public void setBooking_id(int booking_id) {
		this.booking_id = booking_id;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStatusbook() {
		return statusbook;
	}
	public void setStatusbook(String statusbook) {
		this.statusbook = statusbook;
	}
	public EquipmentBean getEquipmentBean() {
		return equipmentBean;
	}
	public void setEquipmentBean(EquipmentBean equipmentBean) {
		this.equipmentBean = equipmentBean;
	}
	public UserBean getUserBean() {
		return userBean;
	}
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}	

	public String getMatric_no() {
		return matric_no;
	}
	public String getEquip_namesB() {
		return equip_namesB;
	}

public void setMatric_no(String matric_no) {
	// TODO Auto-generated method stub
	this.matric_no=matric_no;
	
}
public void setEquip_namesB(String equip_namesB) {
	this.equip_namesB=equip_namesB;
	// TODO Auto-generated method stub
	
}
public void setEquip_id(int int1) {
	// TODO Auto-generated method stub
	
}
public void setUserid(int int1) {
	// TODO Auto-generated method stub
	
}
public int getEquip_quan() {
	return equip_quan;
}
public void setEquip_quan(int equip_quan) {
	this.equip_quan = equip_quan;
}
public String getWeekof() {
	return weekof;
}
public void setWeekof(String weekof) {
	this.weekof = weekof;
}




}

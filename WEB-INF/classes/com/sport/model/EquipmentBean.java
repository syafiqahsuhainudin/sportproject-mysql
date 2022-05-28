package com.sport.model;

import java.io.Serializable;

public class EquipmentBean implements Serializable {
	

	private int equip_id;
	private String filepath;
	private String base64Image;
	private String equip_name;
	private int equip_quantity;
	
	
	

	public EquipmentBean(int equip_id, String equip_name) {
		super();
		this.equip_id = equip_id;
		this.equip_name = equip_name;
	}

	public EquipmentBean(int equip_id, String filepath, String base64Image, String equip_name, int equip_quantity) {
		super();
		this.equip_id = equip_id;
		this.filepath = filepath;
		this.base64Image = base64Image;
		this.equip_name = equip_name;
		this.equip_quantity = equip_quantity;
	}
	
	public EquipmentBean() {
		// TODO Auto-generated constructor stub
	}

	public int getEquip_id() {
		return equip_id;
	}


	public int setEquip_id(int equip_id) {
		return this.equip_id = equip_id;
	}


	public String getFilepath() {
		return filepath;
	}


	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}


	public String getBase64Image() {
		return base64Image;
	}


	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}


	public String getEquip_name() {
		return equip_name;
	}


	public void setEquip_name(String equip_name) {
		this.equip_name = equip_name;
	}


	public int getEquip_quantity() {
		return equip_quantity;
	}


	public void setEquip_quantity(int equip_quantity) {
		this.equip_quantity = equip_quantity;
	}

}

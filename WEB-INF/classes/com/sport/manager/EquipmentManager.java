package com.sport.manager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import  java.sql.Timestamp;
import java.util.ArrayList;


import com.sport.model.EquipmentBean;



public class EquipmentManager {
	

	
	public ArrayList<EquipmentBean> getAllEquipment() {
		
		// get new connection
		ConnectionManager cm = new ConnectionManager();
		Connection con = cm.getConnection();

		// initialize empty array list
		ArrayList<EquipmentBean> equipments = new ArrayList<EquipmentBean>();

		try {

			// prepare a statement object
		String sql = "select * from equipment";
		PreparedStatement ps = con.prepareStatement(sql);

		// execute
		ResultSet rs = ps.executeQuery();

		// get all records
		while (rs.next()) {
			int eid = rs.getInt("equip_id");
			String eqn = rs.getString("equip_name");

		// create bean and add to array list
		EquipmentBean eb = new EquipmentBean(eid, eqn);
		equipments.add(eb);
		}
		// end while

		} // end try
		catch (Exception e) {
		e.printStackTrace();
		}

		finally {
			
		try {
		con.close();

		} catch (SQLException e) {
		e.printStackTrace();

		}
		}
		return equipments;
		}
	

public boolean deleteTask(int equip_id) {
	
	
	// get new connection
	ConnectionManager cm = new ConnectionManager();
	Connection con = cm.getConnection();
	boolean delStatus = false;
	try {
	
		
		// prepare a statement object
	String sql = "delete from equipment where equip_id=?";
	PreparedStatement ps = con.prepareStatement(sql);
	
	
	// set parameters
	ps.setInt(1,equip_id);
	
	
	// execute query
	int res = ps.executeUpdate();
	
	// if one record changed, that means update is successful
	if (res == 1)
	delStatus = true;
	} catch (Exception e) {
	e.printStackTrace();
	} finally {
	try {
	con.close();
	} catch (SQLException e) {
	e.printStackTrace();
	}
	}
	return delStatus;
	}

}


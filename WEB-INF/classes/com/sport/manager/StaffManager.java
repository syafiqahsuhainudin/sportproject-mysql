package com.sport.manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.sport.manager.ConnectionManager;
import com.sport.model.StaffBean;

public class StaffManager {
	 
	public StaffBean login(String staff_id,String staff_password) throws SQLException{
		//get new connection
		ConnectionManager cm = new ConnectionManager();
		Connection con= cm.getConnection();
		try {
			//prepare a statement object
			String sql="select * from staff where " + "staff_id=? and staff_password=?";
			PreparedStatement ps=con.prepareStatement(sql);
			
			//set parameters
			ps.setString(1, staff_id);
			ps.setString(2, staff_password);
			
			//execute
			ResultSet rs=ps.executeQuery();
			
			//if sql return result,login successful
			//get the user info
			if(rs.next()) {
				Integer st = rs.getInt("id");
				String sd = rs.getString("staff_id");
				String sn = rs.getString("staff_name");
				String sp = rs.getString("staff_phone");
				String se = rs.getString("staff_email");
				String spass = rs.getString("staff_password");
				
				StaffBean staffBean = new StaffBean(st,sd,sn,sp,se, spass);
				return staffBean; //return the staff info 
			}
		}//end try
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
		return null; //failed
	}}
package com.sport.manager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.sport.model.UserBean;

public class UserManager {
	
public boolean register(UserBean userBean) throws SQLException{
	
	ConnectionManager cm = new ConnectionManager();
	Connection con = cm.getConnection();
	boolean insertStatus = false;
	try {
		String sql ="insert into student(no_matric,fullname,email,no_phone,password)" +"values(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		
		ps.setString(1,userBean.getNo_matric());
		ps.setString(2,userBean.getFullname());
		ps.setString(3,userBean.getEmail());
		ps.setString(4,userBean.getNo_phone());
		ps.setString(5,userBean.getPassword());
		
		
		int res = ps.executeUpdate();
		
		
		if(res==1)
			insertStatus=true;
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		finally {
			con.close();
		}
		return insertStatus;
	}

public UserBean login(String no_matric,String password)throws SQLException{
	
	ConnectionManager cm = new ConnectionManager();
	Connection con = cm.getConnection();
	boolean insertStatus = false;
	try {
		String sql ="select * from student where no_matric=? AND password=?";
		PreparedStatement ps = con.prepareStatement(sql);	
	
		ps.setString(1,no_matric);
		ps.setString(2,password);
		
		//execute
		ResultSet rs=(ResultSet) ps.executeQuery();
		
		//if sql return result,login is succesful
		//get user info
		if(rs.next()) {
			int id= rs.getInt("userid");
			String fe= rs.getString("no_matric");
			String fn= rs.getString("fullname");
			String em= rs.getString("email");
			String un= rs.getString("no_phone");
			String p=rs.getString("password");
			
			UserBean userBean=new UserBean(id,fe,fn,em,un,p);
			return userBean;
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	finally {
		con.close();
	}
	return null;
	
}
}


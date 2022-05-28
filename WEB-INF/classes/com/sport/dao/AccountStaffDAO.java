package com.sport.dao;

import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;

import com.sport.manager.ConnectionManager;
import com.sport.model.StaffBean;
import com.sport.model.UserBean;
public class AccountStaffDAO {  
  
	static Connection currentCon = null;	
	
	public static int update(StaffBean s){  
	    int status=0;  
	    try{  
	    	currentCon = ConnectionManager.getConnection(); 
	        PreparedStatement ps=currentCon.prepareStatement(
	        		"update staff set staff_id=?, staff_name=?, staff_phone=?, staff_email=?, staff_password=?  where id= ?");
	        
	        ps.setString(1,s.getStaff_id());  
	        ps.setString(2,s.getStaff_name());  
	        ps.setString(3,s.getStaff_phone());  
	        ps.setString(4,s.getStaff_email());  
	        ps.setString(5,s.getStaff_password());
	        ps.setInt(6,s.getId());  
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	public void deleteAccount(int id) {
	    try {
	    	currentCon = ConnectionManager.getConnection();
	    	PreparedStatement ps=currentCon.prepareStatement("delete from staff where id=?");
	        ps.setInt(1, id);
	        ps.executeUpdate();

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	} 

public static List<StaffBean> getAllRecords(){  
    List<StaffBean> list=new ArrayList<StaffBean>();  
      
    try{  
    	currentCon = ConnectionManager.getConnection(); 
        PreparedStatement ps=currentCon.prepareStatement("select * from staff");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
        	StaffBean s=new StaffBean();  
            s.setId(rs.getInt("id"));  
            s.setStaff_id(rs.getString("staff_id"));  
            s.setStaff_name(rs.getString("staff_name"));  
            s.setStaff_phone(rs.getString("staff_phone"));  
            s.setStaff_email(rs.getString("staff_email"));
            s.setStaff_password(rs.getString("staff_password"));
          
            list.add(s);  
        }  
    }catch(Exception e){System.out.println(e);}  
    return list;  
}  
public static StaffBean getRecordById(int id){  
	StaffBean s=null;  
    try{  
    	currentCon = ConnectionManager.getConnection();   
        PreparedStatement ps=currentCon .prepareStatement("select * from staff where id=?");  
        ps.setInt(1,id);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            s=new StaffBean();
            s.setId(rs.getInt("id"));  
            s.setStaff_id(rs.getString("staff_id"));  
            s.setStaff_name(rs.getString("staff_name"));  
            s.setStaff_phone(rs.getString("staff_phone"));  
            s.setStaff_email(rs.getString("staff_email")); 
            s.setStaff_password(rs.getString("staff_password"));
        }  
    }catch(Exception e){System.out.println(e);}  
    return s;  
}

}
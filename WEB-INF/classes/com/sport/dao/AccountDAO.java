package com.sport.dao;



import java.sql.*;  
import java.util.ArrayList;  
import java.util.List;

import com.sport.manager.ConnectionManager;
import com.sport.model.UserBean;

public class AccountDAO {  
  
	static Connection currentCon = null;	
public static int save(UserBean u){  
    int status=0; 
    
    try{  
    	currentCon = ConnectionManager.getConnection(); 
        PreparedStatement ps=currentCon.prepareStatement(  
        		"insert into student(no_matric,fullname,email,no_phone,password)values(?,?,?,?,?)");  
        ps.setString(1,u.getNo_matric());  
        ps.setString(2,u.getFullname());  
        ps.setString(3,u.getEmail());  
        ps.setString(4,u.getNo_phone());  
        ps.setString(5,u.getPassword());  

        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public static int update(UserBean u){  
    int status=0;  
    try{  
    	currentCon = ConnectionManager.getConnection(); 
        PreparedStatement ps=currentCon.prepareStatement("update student set no_matric = ?, fullname=?, email=?, no_phone=?, password=?  where userid= ?");
        ps.setString(1,u.getNo_matric());  
        ps.setString(2,u.getFullname());  
        ps.setString(3,u.getEmail());  
        ps.setString(4,u.getNo_phone());  
        ps.setString(5,u.getPassword());  
        ps.setInt(6,u.getUserid());  
        status=ps.executeUpdate();  
    }catch(Exception e){System.out.println(e);}  
    return status;  
}  
public void deleteAccount(int userid) {
    try {
    	currentCon = ConnectionManager.getConnection();
    	PreparedStatement ps=currentCon.prepareStatement("delete from student where userid=?");
        ps.setInt(1, userid);
        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
} 
public static List<UserBean> getAllRecords(){  
    List<UserBean> list=new ArrayList<UserBean>();  
      
    try{  
    	currentCon = ConnectionManager.getConnection(); 
        PreparedStatement ps=currentCon.prepareStatement("select * from student");  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
        	UserBean u=new UserBean();  
            u.setUserid(rs.getInt("userid"));  
            u.setNo_matric(rs.getString("no_matric"));  
            u.setFullname(rs.getString("fullname"));  
            u.setEmail(rs.getString("email"));  
            u.setNo_phone(rs.getString("no_phone"));  
            u.setPassword(rs.getString("password"));
          
            list.add(u);  
        }  
    }catch(Exception e){System.out.println(e);}  
    return list;  
}  
public static UserBean getRecordById(int userid){  
	UserBean u=null;  
    try{  
    	currentCon = ConnectionManager.getConnection();   
        PreparedStatement ps=currentCon .prepareStatement("select * from student where userid=?");  
        ps.setInt(1,userid);  
        ResultSet rs=ps.executeQuery();  
        while(rs.next()){  
            u=new UserBean();  
            u.setUserid(rs.getInt("userid"));  
            u.setNo_matric(rs.getString("no_matric"));  
            u.setFullname(rs.getString("fullname"));  
            u.setEmail(rs.getString("email"));  
            u.setNo_phone(rs.getString("no_phone"));  
            u.setPassword(rs.getString("password"));
        }  
    }catch(Exception e){System.out.println(e);}  
    return u;  
}

}
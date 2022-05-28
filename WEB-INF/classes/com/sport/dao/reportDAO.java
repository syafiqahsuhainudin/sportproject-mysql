package com.sport.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sport.manager.ConnectionManager;
import com.sport.model.BookingBean;

public class reportDAO {
	
	public static List<BookingBean> getAllRecords(){  
	    List<BookingBean> list=new ArrayList<BookingBean>();  
	      
	    try{  
	    	Connection currentCon = ConnectionManager.getConnection(); 
	        PreparedStatement ps=currentCon.prepareStatement("SELECT YEAR(date) AS Year, WEEK(date) AS Week,DATE_FORMAT(date, '%b %e') AS Weekof, SUM(quantity) AS quantity FROM booking GROUP BY Week ");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	BookingBean u=new BookingBean();  
	        	 u.setYear(rs.getString("Year"));  
		            u.setWeek(rs.getString("Week"));
		            u.setWeekof(rs.getString("Weekof"));  
		            u.setQuantity(rs.getInt("quantity"));
	             
	         
	           
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  

}

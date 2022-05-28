package com.sport.dao;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.sport.manager.ConnectionManager;
import com.sport.model.EquipmentBean;



public class EquipmentDA0 {
	
	static Connection currentCon = null;	
	static ResultSet rs = null; 
	static PreparedStatement ps=null;
	static Statement stmt=null;
	public static int addequipment(EquipmentBean u){  
	    int status=0; 
	    
	    try{  
	    	currentCon = ConnectionManager.getConnection(); 
	        PreparedStatement ps=currentCon.prepareStatement(  
	        		"insert into equipment(equip_picture,equip_name,equip_quantity)values(?,?,?)");  
	    	String filepath = u.getFilepath();
			FileInputStream fin=new FileInputStream(filepath);  
    		ps.setBinaryStream(1,fin,fin.available());;  
	        ps.setString(2,u.getEquip_name());  
	        ps.setInt(3,u.getEquip_quantity());  
	  

	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  
	public static int updateequipment(EquipmentBean u){  
	    int status=0;  
	    try{  
	    	currentCon = ConnectionManager.getConnection(); 
	        PreparedStatement ps=currentCon.prepareStatement(  
	 
	        "update equipment set equip_picture = ?, equip_name=?, equip_quantity=? where equip_id= ?");
	       	String filepath = u.getFilepath();
	    			FileInputStream fin=new FileInputStream(filepath);  
	        		ps.setBinaryStream(1,fin,fin.available());; 
	        ps.setString(2,u.getEquip_name());  
	        ps.setInt(3,u.getEquip_quantity());  
	        ps.setInt(4,u.getEquip_id()); 
	       
	        status=ps.executeUpdate();  
	    }catch(Exception e){System.out.println(e);}  
	    return status;  
	}  

	public static boolean delete(int equip_id)
	{
		boolean status = false;
		try {
        	currentCon = ConnectionManager.getConnection();
    		ps=currentCon.prepareStatement("DELETE FROM EQUIPMENT WHERE equip_id= ?");
    		ps.setInt(1,equip_id);
    	    int res = ps.executeUpdate();
    	    
    	    if(res == 1) {
    	    	status = true;
    	    }
    	    
    	    
    	    
    	}catch (Exception ex) {
    	  System.out.println("failed: An Exception has occurred! " + ex);
    	}
    	finally {
    		if (ps != null) {
    			try {
    				ps.close();
    			} catch (Exception e) {
    			}
    			ps = null;
    		}
    		
    		if (currentCon != null) {
    			try {
    				currentCon.close();
    			} catch (Exception e) {
    			}
    			currentCon = null;
    		}
    	}
		return status;
	}
	public static List<EquipmentBean> getAllRecords(){  
	    List<EquipmentBean> list=new ArrayList<EquipmentBean>();  
	      
	    try{  
	    	currentCon = ConnectionManager.getConnection(); 
	        PreparedStatement ps=currentCon.prepareStatement("select * from equipment");  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	        	EquipmentBean u=new EquipmentBean();  
	            u.setEquip_id(rs.getInt("equip_id")); 
	            Blob blob = rs.getBlob("equip_picture");
                
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);                  
                }
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                 
                u.setBase64Image(base64Image);
                inputStream.close();
                outputStream.close();
	          
	            u.setEquip_name(rs.getString("equip_name"));  
	            u.setEquip_quantity(rs.getInt("equip_quantity"));  
	    
	          
	            list.add(u);  
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return list;  
	}  
	public static EquipmentBean getRecordById(int equip_id){  
		EquipmentBean u=null;  
	    try{  
	    	currentCon = ConnectionManager.getConnection();   
	        PreparedStatement ps=currentCon .prepareStatement("select * from equipment where equip_id=?");  
	        ps.setInt(1,equip_id);  
	        ResultSet rs=ps.executeQuery();  
	        while(rs.next()){  
	            u=new EquipmentBean();  
	        
	            u.setEquip_id(rs.getInt("equip_id")); 
	            Blob blob = rs.getBlob("equip_picture");
                
                InputStream inputStream = blob.getBinaryStream();
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[4096];
                int bytesRead = -1;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);                  
                }
                byte[] imageBytes = outputStream.toByteArray();
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                 
                u.setBase64Image(base64Image);
                inputStream.close();
                outputStream.close();
	          
	            u.setEquip_name(rs.getString("equip_name"));  
	            u.setEquip_quantity(rs.getInt("equip_quantity"));  
	    
	        }  
	    }catch(Exception e){System.out.println(e);}  
	    return u;  
	}

	}



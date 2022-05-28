package com.sport.manager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

	static  Connection con;
	
        
            public static   Connection getConnection(){

                try {

                    Class.forName("com.mysql.jdbc.Driver");
            
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sport","root","");
                    
                    return con;
                }
                    catch (Exception e) {
                        e.printStackTrace();
                    	return null;
                    }
			
                }
            }
	

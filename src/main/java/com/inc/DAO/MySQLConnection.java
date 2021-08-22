package com.inc.DAO;

import java.sql.*;  


public class MySQLConnection {

	public static Connection connectToMySQL(){  
		Connection con = null;
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/poultry","root","root"); 
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return con;  
	} 
	
}
	
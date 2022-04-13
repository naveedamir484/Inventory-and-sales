package com.wipro.sales.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	public static Connection getDBConnection() {
		
		try
		{   
			 String url="jdbc:oracle:thin:@localhost:1521:xe";
			 //String url="jdbc:mysql://localhost:3306/wipro";
			 String user="xe";
			 String password="scott";
			
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); //new drive doesnt need this;
			Connection con=DriverManager.getConnection(url, user, password);
			//System.out.println("Connection Established...");
			return con;
		
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		return null;
		
		
		
	}
	
}

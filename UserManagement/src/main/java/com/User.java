package com;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class User {
	
	public String insertUser(String name, String phone, String address, String mail,String password,String confirmpassword) 
	{
		
		String output="";
		
		try {
			
			Connection con = DBConnection.getConnection();
			
			if (con == null) 
			{ 
				return "Error while connecting to the database"; 
			}
		
		// create a prepared statement
		String query = " insert into user (`id`,`name`,`phone`,`address`,`mail`,'password','confirmpassword')"
		 + " values (?, ?, ?, ?, ?,?,?)"; 
		PreparedStatement preparedStmt = con.prepareStatement(query); 
		// binding values
		
		if(password.equals(confirmpassword)) {
			
			preparedStmt.setInt(1, 0); 
			preparedStmt.setString(2, name); 
			preparedStmt.setString(3, phone); 
			preparedStmt.setString(4,address); 
			preparedStmt.setString(5, mail);
			preparedStmt.setString(6,password); 
			preparedStmt.setString(7, confirmpassword);
			
			//execute the statement
			preparedStmt.execute(); 
			con.close();
			
			output = "Insert Successfull"; 
		}else {
			output = "Password not matched";
		}
		
		} 
		catch (Exception e) 
		{ 
			output = "Error while inserting"; 
			System.err.println(e.getMessage()); 
		} 
		return output; 
	}
	
	
	public String readItems()
	{ 
		 String output = ""; 
		 
		 try {
				
				Connection con = DBConnection.getConnection();
				
				if (con == null) 
				{ 
					return "Error while connecting to the database"; 
				}
				
		 }catch (Exception e) 
		 { 
				output = "Error while inserting"; 
				System.err.println(e.getMessage()); 
		 } 
		 return output; 
	}



}

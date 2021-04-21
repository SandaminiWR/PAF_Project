package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
	
	private static ResultSet rs = null;
	private static PreparedStatement pst = null;
	private static Statement stmt = null;
	
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
		String query = " insert into user (`id`,`name`,`phone`,`address`,`email`,`password`)"
		 + " values (?, ?, ?, ?, ?,?)"; 
		PreparedStatement preparedStmt = con.prepareStatement(query); 
		// binding values
		
		if(password.equals(confirmpassword)) {
			
			preparedStmt.setInt(1, 0); 
			preparedStmt.setString(2, name); 
			preparedStmt.setString(3, phone); 
			preparedStmt.setString(4,address); 
			preparedStmt.setString(5, mail);
			preparedStmt.setString(6,password); 
			System.out.print(name);
			
			//execute the statement
			preparedStmt.execute(); 
			//con.close();
			
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
	
	
	public String readUser()
	{ 
		 String output = ""; 
		 
		 try {
				
				Connection con = DBConnection.getConnection();
				
				if (con == null) 
				{ 
					return "Error while connecting to the database"; 
				}
				
				// Prepare the html table to be displayed
				output = "<table border='1'>" 
				+ "<tr><th>User ID</th><th>Name</th><th>Phone</th><th>Address</th>"
				+ "<th>Email</th><th>Password</th><th>Update</th><th>Remove</th></tr>";

				
				String query = "select * from user";
				Statement stmt = con.createStatement(); 
				ResultSet rs = stmt.executeQuery(query); 
				
				
				// iterate through the rows in the result set
				while (rs.next()) 
				{ 
					 String UserID = Integer.toString(rs.getInt(1)); 
					 String userName = rs.getString(2); 
					 String phone = rs.getString(3); 
					 String address = rs.getString(4); 
					 String email = rs.getString(5);
					 String password = rs.getString(6);
					 
					// Add into the html table
					output += "<tr><td>" + UserID + "</td>"; 
					output += "<td>" + userName + "</td>"; 
					output += "<td>" + phone + "</td>"; 
					output += "<td>" + address + "</td>"; 
					output += "<td>" + email + "</td>"; 
					output += "<td>" + password + "</td>"; 
					// buttons
					output += "<td><input name='btnUpdate' type='button' value='Update'></td>"
					 + "<td><form method='post' action='user.jsp'>"
							
					 + "<input name='btnRemove' type='submit' value='Remove'>"
					 + "<input name='uid' type='hidden' value='" + UserID + "'>" 
					 + "</form></td></tr>"; 
				}
				
		 }catch (Exception e) 
		 { 
				output = "Error while inserting"; 
				System.err.println(e.getMessage()); 
		 } 
		 
		 
		 
		 return output; 
	}

	public String deleteUser(String id)
	{ 
		 String output = ""; 
		try
		{ 
			Connection con = DBConnection.getConnection();
		
			if (con == null) { 
		      return "Error while connecting to the database for deleting."; 
		    } 
			
			// create a prepared statement
			String query = "delete from user where id=?"; 
			PreparedStatement preparedStmt = con.prepareStatement(query); 
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(id)); 
			 
			// execute the statement
			preparedStmt.execute(); 
			//con.close(); 
			output = "Deleted successfully";

		} 
		catch (Exception e) 
		{ 
		output = "Error while deleting the user."; 
		 System.err.println(e.getMessage()); 
		}
	
	 return output; 
	}



}

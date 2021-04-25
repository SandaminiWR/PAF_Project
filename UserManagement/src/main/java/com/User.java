package com;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class User {
	
	public String insertUser( String name, String phone, String address,String mail,String password,String confirmpassword )  {
		
		Connection con = DBConnection.getConnection();
		
		String output = "";
		
		if (con == null) 
		{ 
			return "Error while connecting to the database"; 
		}
		
		// create a prepared statement
		String query = " insert into User ('id',`name`,`phone`,`address`,`mail`,`password`)"
		 + " values (?, ?, ?, ?, ?,?)"; 
		
		try {
			
			if( password.equals(confirmpassword)) {
				PreparedStatement preparedStmt = con.prepareStatement(query); 
				// binding values
				preparedStmt.setInt(1, 0); 
				preparedStmt.setString(2, name); 
				preparedStmt.setString(3, phone); 
				preparedStmt.setString(4, address); 
				preparedStmt.setString(5, mail);
				preparedStmt.setString(5, password);
				
				//execute the statement
				 preparedStmt.execute();
				 
				 con.close(); 
				 output = "User Inserted successfully"; 
				
			}else {
				
				output="password not matched\n";
			}
			 
			 
			 
			 }catch (Exception e) { 
				 output = "Error while Inserting"; 
				 System.err.println(e.getMessage()); 
		      } 
		
		return output; 
		
	}

	public String readUser()
	{ 
		
		String output = ""; 
		try
		{ 
			Connection con = DBConnection.getConnection();
			
			
			if (con == null) 
			{ 
				return "Error while connecting to the database for reading."; 
			} 
			
			// Prepare the html table to be displayed
			output = "<table border='1'>" 
			+ "<tr><th>Name</th><th>Phone</th><th>Mail</th>"
			+ "<th>Password</th><th>Update</th><th>Remove</th></tr>";
			
			 String query = "select * from user"; 
			 Statement stmt = con.createStatement(); 
			 ResultSet rs = stmt.executeQuery(query); 
			 // iterate through the rows in the result set
			 while (rs.next()) 
			 { 
			 String itemID = Integer.toString(rs.getInt("itemID")); 
			 String itemCode = rs.getString("itemCode"); 
			 String itemName = rs.getString("itemName"); 
			 String itemPrice = Double.toString(rs.getDouble("itemPrice")); 
			 String itemDesc = rs.getString("itemDesc"); 
			 // Add into the html table
			 output += "<tr><td>" + itemCode + "</td>"; 
			 output += "<td>" + itemName + "</td>"; 
			 output += "<td>" + itemPrice + "</td>"; 
			 output += "<td>" + itemDesc + "</td>";
			 // buttons
			 output += "<td><input name=‘btnUpdate’ " 
			 + " type=‘button’ value=‘Update’></td>"
			 + "<td><form method=‘post’ action=‘items.jsp’>"
			 + "<input name=‘btnRemove’ " 
			 + " type=‘submit’ value=‘Remove’>"
			 + "<input name=‘itemID’ type=‘hidden’ " 
			 + " value=‘" + itemID + "‘>" + "</form></td></tr>"; 
			 } 
			 con.close(); 
			 // Complete the html table
			 output += "</table>"; 
			 
		} 
		catch (Exception e) 
		{ 
			output = "Error while reading the items."; 
			 System.err.println(e.getMessage()); 
		}
	 
	 
			return output; 
	}
	
	

	

		

	


}

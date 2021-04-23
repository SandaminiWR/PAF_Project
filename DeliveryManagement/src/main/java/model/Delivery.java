package model;


import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class Delivery {
	//A common method to connect to the DB
	private Connection connect() 
	 { 
			Connection con = null; 
			try
			{ 
				Class.forName("com.mysql.jdbc.Driver"); 
	 
				//Provide the correct details 
				con = DeliveryManager.getConnection("jdbc:mysql://127.0.0.1:3306/test", "root", ""); 
			} 
			catch (Exception e) 
			{e.printStackTrace();} 
			return con; 
	 } 
	public String insertDelivery(String CID, String type, String desc) 
	 { 
	       String output = ""; 
	       try
	       { 
	    	   	Connection con = connect(); 
	    	   	if (con == null) 
	    	   	{return "Error while connecting to the database for inserting."; } 
	    	   	// create a prepared statement
	    	   	String query = " insert into delivery (`DID`,`CID`,`Dtype`,`Ddesc`)"+ " values (?, ?, ?, ?)"; 
	    	   
	    	   	PreparedStatement preparedStmt = con.prepareStatement(query); 
	    	   	// binding values
	    	   	preparedStmt.setInt(1, 0); 
	    	   	preparedStmt.setString(2, CID); 
	    	   	preparedStmt.setString(3, type);
	    	   	preparedStmt.setString(4, desc); 
	    	   	// execute the statement
	    	   	preparedStmt.execute(); 
	    	   	con.close(); 
	    	   	output = "Inserted successfully"; 
	 } 
	 catch (Exception e) 
	       { 
		 		output = "Error while inserting the delivery."; 
		 		System.err.println(e.getMessage()); 
	       } 
	 return output; 
     } 
	public String readDelivery() 
	 { 
			String output = ""; 
			try
	 { 
					Connection con = connect(); 
					if (con == null) 
					{return "Error while connecting to the database for reading."; } 
					
					// Prepare the html table to be displayed
					output = "<table border='1'><tr><th>Delivery CustomerID</th>" +		
							"<th>Delivery Type</th>" +
							"<th>Delivery Description</th>" +
							"<th>Update</th><th>Remove</th></tr>"; 
	 
					String query = "select * from delivery"; 
					Statement stmt = con.createStatement(); 
					ResultSet rs = stmt.executeQuery(query); 
	 
					// iterate through the rows in the result set
					while (rs.next()) 
					{ 
						String DID = Integer.toString(rs.getInt("DID"));
						String CID = rs.getString("CID");
						String Dtype = rs.getString("Dtype"); 				  
						String DDesc = rs.getString("Ddesc"); 
						// Add into the html table
						
						output += "<tr><td>" + CID + "</td>"; 
						output += "<td>" + Dtype + "</td>";
						output += "<td>" + Ddesc + "</td>"; 
						// buttons
						
						output += "<td><input name='btnUpdate' type='button' value='Update' class='btn btn-secondary'></td>"
										+ "<td><form method='post' action='delivery.jsp'>"+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
										+ "<input name='DID' type='hidden' value='" + DID 
										+ "'>" + "</form></td></tr>"; 
	 } 
	 
					con.close(); 
					// Complete the html table
					output += "</table>"; 
	 		} 
			catch (Exception e) 
			{ 
				output = "Error while reading the delivery."; 
				System.err.println(e.getMessage()); 
			} 
			return output; 
	 } 
	public String updateDelivery(String DID,String CID, String type ,String desc)
	 { 
			String output = ""; 
			try
			{ 
					Connection con = connect(); 
					if (con == null) 
					{return "Error while connecting to the database for updating."; } 
					
					// create a prepared statement
					String query = "UPDATE delivery SET CID=?,Dtype=?,Ddesc=? WHERE DID=?"; 
					
					PreparedStatement preparedStmt = con.prepareStatement(query); 
					// binding values
					preparedStmt.setString(1, CID);
					preparedStmt.setString(2, type);
					preparedStmt.setString(3, desc); 
					preparedStmt.setInt(4, Integer.parseInt(DID)); 
					// execute the statement
					preparedStmt.execute(); 
					con.close(); 
					output = "Updated successfully"; 
			} 
			catch (Exception e) 
			{ 
					output = "Error while updating the delivery."; 
					System.err.println(e.getMessage()); 
			} 
			return output; 
	 } 
	public String deleteDelivery(String DID) 
	 { 
		String output = ""; 
		try
		{ 
				Connection con = connect(); 
				if (con == null) 
				{return "Error while connecting to the database for deleting."; } 
				// create a prepared statement
				String query = "delete from items where DID=?"; 
				PreparedStatement preparedStmt = con.prepareStatement(query); 
				// binding values
				preparedStmt.setInt(1, Integer.parseInt(DID)); 
				// execute the statement
				preparedStmt.execute(); 
				con.close(); 
				
				output = "Deleted successfully"; 
	 } 
	 catch (Exception e) 
	 { 
	 
		 output = "Error while deleting the delivery."; 
		 System.err.println(e.getMessage()); 
	 } 
	 return output; 
	 } 

}

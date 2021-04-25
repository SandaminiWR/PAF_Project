package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//server-model Implementation
public class Payment {

	 //DB Connection method
	public Connection connect()
	{ 
		Connection con = null; 
	 
	 try 
	 { 
	 Class.forName("com.mysql.jdbc.Driver"); 
	 con= DriverManager.getConnection("jdbc:mysql://localhost:3308/paymentmanagements", "root", ""); 
	 
	 //For testing
	 System.out.print("Successfully Connected"); 
	 
	 } 
	 catch(Exception e) 
	 { 
	 e.printStackTrace(); 
	 } 
	 
	 return con; 
	
	}
	
	 //Insert Payment
	public String insertPayment( String date, String amount, String cardNumber , String postalNumber ) {
		Connection con = connect();
		String output = "";
		if (con == null) {
			
			return "Error while connecting to the database";
		}

		// create a prepared statement
		String query = " INSERT INTO `payment`(`payId`, `date`, `amount`, `cardNumber`, `postalNumber`)"+" VALUES (?,?,?,?,?)";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = con.prepareStatement(query);

			
			preparedStmt.setInt(1, 0 );
			preparedStmt.setString(2, date);
			preparedStmt.setString(3, amount);
			preparedStmt.setString(4, cardNumber);
			preparedStmt.setString(5, postalNumber);
			
			
			preparedStmt.execute();
			con.close();
			output = "Inserted Successfully";
			
			
		} catch (SQLException e) {
			
			output = "Error while inserting";
			System.err.println(e.getMessage());
		}
		

		return output;
	}
	
	//Read Items
	public String readPayment() {
		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}

			// Prepare the html table to be displayed
			output = "<table border='1'>" + "<th><th>Payment Date</th><th>Payment Amount</th><th>Payment CardNumber</th><th>Payment PostalNumber</th>"
					+ "</th><th>Update</th><th>Remove</th></tr>";

			String query = "select * from payment";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			
			// iterate through the rows in the result set
			while (rs.next()) {
				String paymentPayId  = Integer.toString(rs.getInt("paymentPayId"));
				String paymentDate = rs.getString("paymentDate");
				String paymentAmount = rs.getString("paymentAmount");
				String paymentCardNumber = rs.getString("paymentCardNumber");
				String paymentPostalNumber = rs.getString("paymentPostalNumber");
				
				
				// Add a row into the html table
				output += "<tr><td>" + paymentDate + "</td>";
				output += "<td>" + paymentAmount + "</td>";
				output += "<td>" + paymentCardNumber + "</td>";
				output += "<td>" + paymentPostalNumber+ "</td>";
				
				
				
				
				// Buttons
				output += "<td>" + "<form method='post' action='payment.jsp'>"
						+ "<input name='btnUpdate' type='submit' value='Update' class='btn btn-info' >" 
						+ "<input name='update_paymentPayId' type='hidden' value='" + paymentPayId + "'>" + "</form>" + "<td>"
						+ "<form method='post' action='item.jsp'>"
						+ "<input name='btnRemove' type='submit' value='Remove' class='btn btn-danger'>"
						+ "<input name='paymentPayId' type='hidden' value='" + paymentPayId + "'>" + "</form></td></tr>";
			}
			
		} catch (Exception e) {
			
			output = "Error while reading the payments.";
			System.err.println(e.getMessage());
		}

		return output;
	}
	//Update Payments
	public String updatePayment(String payId, String date, String amount, String cardNumber, String postalNumber)
	 { 
	 String output = ""; 
	 try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 {return "Error while connecting to the database for updating."; } 
	 
	 // create a prepared statement
	 String query = "UPDATE payement SET =paymentDate?,=paymentAmount?,=?,paymentCardNumbe=?,=paymentPostalNumbe? WHERE =paymentPayId?"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 
	 // binding values
	 preparedStmt.setString(1, date ); 
	 preparedStmt.setString(2, amount); 
	 preparedStmt.setString(3, cardNumber); 
	 preparedStmt.setString(4, postalNumber);   
	 preparedStmt.setInt(5, Integer.parseInt(payId)); 
	 
	 // execute the statement
	 preparedStmt.execute(); 
	 con.close(); 
	 output = "Updated Successfully"; 
	 } 
	 catch (Exception e) {
	 		 
	 output = "Error while updating the payment."; 
	 System.err.println(e.getMessage()); 
	 
	 } 
	 
	 return output; 
 } 
	//Delete Payments
	public String deletePayment(String paymentPayId)
	{ 
	 String output = ""; 
	try
	 { 
	 Connection con = connect(); 
	 if (con == null) 
	 { 
	 return "Error while connecting to the database for deleting."; 
	 } 
	 
	 // create a prepared statement
	 String query = "delete from item where paymentPayId=?"; 
	 PreparedStatement preparedStmt = con.prepareStatement(query); 
	 
	 // binding values
	 preparedStmt.setInt(1, Integer.parseInt(paymentPayId)); 
	 
	 // execute the statement
	 preparedStmt.execute(); 
	 con.close(); 
	 output = "Deleted Successfully"; 	 
	 } 
	
	catch (Exception e) {
	 	
	 output = "Error while deleting thepayment."; 
	 System.err.println(e.getMessage()); 
	 
	 } 
	
	return output; 
	
}
	
}

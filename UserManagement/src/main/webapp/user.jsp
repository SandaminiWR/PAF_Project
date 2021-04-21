<%@page import="com.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%
if (request.getParameter("id") != null) 
{ 
 session.setAttribute("id", request.getParameter("id")); 
 session.setAttribute("name", request.getParameter("name")); 
 session.setAttribute("phone", request.getParameter("phone")); 
 session.setAttribute("address", request.getParameter("address"));
 session.setAttribute("mail", request.getParameter("mail")); 
 session.setAttribute("password", request.getParameter("password")); 
 session.setAttribute("confirmpassword", request.getParameter("confirmpassword"));
 

 DBConnection db = new DBConnection(); 
  db.connect();//For testing the connect method
 

} 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
</head>
<body>

	
	
<h1>User Management</h1>
	<form method="post" action="user.jsp">
		 ID: <input name="id" type="text"><br>
		 Name: <input name="name" type="text"><br>
		 Phone: <input name="phone" type="number"><br>
		 Address : <input name="address" type="text"><br>
		 Mail : <input name="mail" type="email"><br>
		 Password : <input name="password" type="password"><br>
		 Confirm Password : <input name="confirmpassword" type="password"><br>
		 <input name="btnSubmit" type="submit" value="Save">
 
	</form>
<br>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Phone</th>
			<th>Address</th>
			<th>Mail</th>
			<th>Password</th>
			<th>Update</th>
			<th>Remove</th>
	
		</tr>
	
		<tr>
			<td><%out.print(session.getAttribute("id")); %></td>
			<td><%out.print(session.getAttribute("name")); %></td>
			<td><%out.print(session.getAttribute("phone")); %></td>
			<td><%out.print(session.getAttribute("address")); %></td>
			<td><%out.print(session.getAttribute("mail")); %></td>
			<td><%out.print(session.getAttribute("password")); %></td>
			<td><%out.print(session.getAttribute("confirmpassword")); %></td>
		
			<td><input name="btnUpdate" type="button" value="Update"></td>
			<td><input name="btnRemove" type="button" value="Remove"></td>
		</tr>
		
		
	</table>


</body>
</html>
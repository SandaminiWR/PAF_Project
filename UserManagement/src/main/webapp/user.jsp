<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Management</title>
</head>
<body>

<h1>User Management</h1>
	<form method="post" action="Usre.jsp">
		 ID: <input name="itemCode" type="text"><br>
		 Name: <input name="itemName" type="text"><br>
		 Phone: <input name="itemPrice" type="number"><br>
		 Address : <input name="itemDesc" type="text"><br>
		 Mail : <input name="itemDesc" type="email"><br>
		 Password : <input name="itemDesc" type="password"><br>
		 Confirm Password : <input name="itemDesc" type="password"><br>
		 <input name="btnSubmit" type="submit" value="Save">
 
	</form>
<br>
<table border="1">
	<tr>
		<th>ID</th><th>Name</th><th>Phone</th><th>Address</th><th>Mail</th><th>Password</th><th>Update</th><th>Remove</th>

	</tr>
	<tr>
		<td>1000</td><td>SAndhu</td><td>766971698</td><td>maharagama</td><td>thar@gmail.com</td><td>sadu123</td>
		<td><input name="btnUpdate" type="button" value="Update"></td>
		<td><input name="btnRemovee" type="button" value="Remove"></td>
	</tr>
		
</table>


</body>
</html>
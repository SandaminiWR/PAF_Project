<%@page import="model.Payment"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%  //insert
     if (request.getParameter("paymentPayId") != null)
{
	 Payment paymentObj = new Payment();
	 String stsMsg = paymentObj.insertPayment(request.getParameter("paymentPayId"),
			 request.getParameter("paymentDate"),
			 request.getParameter("paymentAmount"),
			 request.getParameter("paymentCardNumber"),
			 request.getParameter("paymentPostalNumber"));
			 
	 
	 System.out.println(stsMsg);
	 session.setAttribute("statusMsg", stsMsg);
} 


//delete
	if (request.getParameter("paymentPayId") != null) {

	Payment paymentmObj = new Payment(); 
	String stsMsg = paymentObj.deletePayment(request.getParameter("paymentPayId")); 

	System.out.println(stsMsg);
	session.setAttribute("statusMsg", stsMsg); 
}
    
    
%>  
    
<!DOCTYPE html>
<html>
<head>


<link rel="stylesheet" href="Views/bootstrap.min.css">


<meta charset="ISO-8859-1">
<title>Payment Management</title>
</head>
<body>

<div class="jumbotron jumbotron-fluid">

<center><h1 style="font-size:380%;"><b>Payment Management</b></h1></center>
<br>
<br>
<div class="container">
 <div class="row">
 	<div class="col">
 	
 	
<form method="post" action="payment.jsp">
 	Payment Date: <input name="paymentDate" type="text" class="form-control">
 	Payment Amount: <input name="paymentAmount" type="text" class="form-control">
	Payment CardNumber: <input name="paymentCardNumber" type="text" class="form-control"> 
	Payment PostalNumber:<input name="paymentPostalNumber" type="text" class="form-control"><br><br>
<center><input name="btnSubmit" type="submit" value="Save Payment" class="btn btn-primary"> </center>

<br>

</form>

<div class="alert alert-success">
 <% out.print(session.getAttribute("statusMsg"));%>
</div>



<%
 out.print(session.getAttribute("statusMsg")); 
%>
<br>

<%
 Payment paymentObj = new Payment(); 
 out.print(paymentObj.readPayment()); 
%>

</div>
 </div>
</div>
        
</body>
</html>   

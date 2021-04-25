package com;

import javax.swing.text.Document;
import javax.swing.text.html.parser.Parser;
import javax.tools.JavaFileObject;

import org.eclipse.jdt.internal.compiler.parser.JavadocParser;

import com.mysql.cj.xdevapi.JsonParser;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import model.Payment;


//RESTful API Implementation
@Path("/Payment")
public class PaymentService {
	
	Payment paymentObj = new Payment();

  @GET
  @Path("/")
  @Produces(MediaType.TEXT_HTML)
  
   public String readPayement() {
		return paymentObj.readPayments();
	
 }
  
//Insert Payment() method
	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	
	public String insertPayment(@FormParam("paymentDate") String paymentDate, 
			@FormParam("paymentAmount") String paymentAmount, 
			@FormParam("pamentCardNumber") String paymentCardNumber, 	 
			@FormParam("paymentPostalNumber") String paymentPostalNumber)
			
{ 
String output = paymentObj.insertPayment( paymentDate, paymentAmount, paymentCardNumber, paymentPostalNumber); 

return output; 
}
	
	//Update Payment() method
		@PUT
		@Path("/") 
		@Consumes(MediaType.APPLICATION_JSON) 
		@Produces(MediaType.TEXT_PLAIN) 
		
		public String updateItem(String paymentData) 
		{ 
			
		//Convert the input string to a JSON object 
			JsonObject paymentObject = new JsonParser().parse(paymentData).getAsJsonObject(); 
		 
		//Read the values from the JSON object
		 String paymentPayId =  paymentObject.get("paymentPayId").getAsString(); 
		 String paymentDate = paymentObject.get("paymentDate").getAsString(); 
		 String paymentAmount = paymentObject.get("pamentAmount").getAsString(); 
		 String pamentCardNumber = paymentObject.get("pamentCardNumber").getAsString(); 
		 String paymentPostalNumber = paymentObject.get("paymentPostalNumber").getAsString(); 
		 
		 
		 String output = paymentObj.updatePayment(paymentPayId, paymentDate, paymentAmount, pamentCardNumber, paymentPostalNumber);
		return output; 
		}
	
		//Delete Payment() method
		@DELETE
		@Path("/") 
		@Consumes(MediaType.APPLICATION_XML) 
		@Produces(MediaType.TEXT_PLAIN) 
		
		public String deletePayment(String paymentData) 
		{ 
			
		//Convert the input string to an XML document
		 Document doc = Jsoup.parse(paymentData, "", Parser.xmlParser()); 
		 
		//Read the value from the element <paymentPayId>
		 String paymentPayId =  doc.select("paymentPayId").text(); 
		 String output = paymentObj.deletePayment(paymentPayId); 
		 
		return output; 
		}
	
}

package com;

import model.Delivery;

public class DeliveryService {
	Delivery deliveryObj = new Delivery(); 
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readDelivery() 
	 { 
	 return "Hello"; 
	 } 

}

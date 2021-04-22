package com;

//For REST Service
import javax.ws.rs.*; 
import javax.ws.rs.core.MediaType; 
//For JSON
import com.google.gson.*;

import model.User;

//For XML
import org.jsoup.*; 
import org.jsoup.parser.*; 
import org.jsoup.nodes.Document; 

@Path("/User")
public class UserService {
	
		 User usObj = new User(); 
		@GET
		@Path("/") 
		@Produces(MediaType.TEXT_HTML) 
		public String readUser() 
		 { 
		 return usObj.readUser(); 
		 }
	
		@POST
		@Path("/") 
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)

	public String insertUSer
				(@FormParam("name") String name, 
				 @FormParam("phone") String phone, 
				 @FormParam("address") String address, 
				 @FormParam("password") String password,
	 			 @FormParam("confirmpassword") String confirmpassword)
				{
			String output = usObj.insertUser(name, phone, address, address, password, confirmpassword);
				return output;
				}
}



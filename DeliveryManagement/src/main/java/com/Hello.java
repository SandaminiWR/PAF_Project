package com;


@Path("/Hello")
public class Hello {
	
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_PLAIN) 
	public String hello() 
	 { 
	 return "Hello world."; 
	 } 

	@GET
	@Path("/{name}") 
	@Produces(MediaType.TEXT_PLAIN) 
	public String helloName(@PathParam("name") String name) 
	{ 
	return "Hello " + name; 
	}

}

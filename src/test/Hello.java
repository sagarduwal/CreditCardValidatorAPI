package test;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/hello")
public class Hello {
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayHello() {
		String resource = "<?xml version='1.0'?>" + "<hello> Hello from XML</hello>";
		return resource;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sayHelloJSON() {
		String resource = null;
		return resource;
	}

	
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String valid(@QueryParam("Card_no") String Card_no) {
		System.out.println("Card is " + Card_no);
		String resource;
		int intcard = Integer.parseInt(Card_no);
		System.out.println("Card is " + intcard);
		resource = "<h1>Valid</h1>";
		
		return resource;
	}

}

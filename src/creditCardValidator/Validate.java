package creditCardValidator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/validates")
public class Validate {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String validateCard(@QueryParam("card_num") String cardNum) {
		
		System.out.println("GET method is called!");
		
		Luhn checkLuhn = new Luhn();
		return "{"
				+"\n"
				+"	\"Card Number\": " + cardNum + ","
				+"\n"
				+"	\"Valid\": " + checkLuhn.luhnAlgorithm(cardNum)
				+"\n"
				+"}";
	}

}
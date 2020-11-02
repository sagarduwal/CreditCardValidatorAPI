package creditCardValidator;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Path("/validate")
public class Validate {
	
	private String resource;

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String validateCard(@QueryParam("Card_num") String cardNum) {
		Luhn checkLuhn = new Luhn();
		System.out.println("Card is " + cardNum);
		
        if (checkLuhn.luhnAlgorithm(cardNum)) {
            System.out.println("This is a valid card");
        	resource = "<h1>Valid</h1>";
        }
        else {
            System.out.println("This is not a valid card");
			resource = "<h1>Invalid</h1>";
        }
		return resource;
	}

}
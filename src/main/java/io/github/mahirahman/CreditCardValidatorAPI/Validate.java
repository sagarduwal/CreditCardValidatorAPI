package io.github.mahirahman.CreditCardValidatorAPI;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonObject;

@Path("/validates")
public class Validate {
	
	//GET method that validates a credit card using an instance of the Luhn class 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String validateCard(@QueryParam("card_num") String cardNum) {
	//eg) localhost:8080/CreditCardValidatorAPI/v1/validates?card_num={cardNum}

		System.out.println("GET method is called!");

		//Add data to the JSON object
		JsonObject response = Json.createObjectBuilder()
			.add("Card Number", cardNum)
			.add("Valid", Luhn.luhnAlgorithm(cardNum))
			.build();

		//Returns JSON response in String format
		return response.toString();
		
	}

}

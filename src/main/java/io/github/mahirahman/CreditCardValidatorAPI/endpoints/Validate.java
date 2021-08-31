// Credit Card validation endpoint

package io.github.mahirahman.CreditCardValidatorAPI.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.github.mahirahman.CreditCardValidatorAPI.model.Luhn;

import javax.json.Json;
import javax.json.JsonObject;

@Path("/validates")
@Produces(MediaType.APPLICATION_JSON)
public class Validate {

	// GET method that validates a credit card using an instance of the Luhn class
	// localhost:8080/CreditCardValidatorAPI/v1/validates?card_num={cardNum}
	@GET
	public String validateCard(@QueryParam("card_num") long cardNum) {

		Luhn checkLuhn = new Luhn();
		// Add data to the JSON object
		JsonObject response = Json.createObjectBuilder()
			.add("Card Number", cardNum)
			.add("Valid", checkLuhn.luhnAlgorithm(String.valueOf(cardNum)))
			.build();

		// Returns JSON response
		return response.toString();

	}
}
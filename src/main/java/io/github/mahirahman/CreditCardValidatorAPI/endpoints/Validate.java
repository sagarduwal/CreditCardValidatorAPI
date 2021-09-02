// Credit Card validation endpoint

package io.github.mahirahman.CreditCardValidatorAPI.endpoints;

import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.github.mahirahman.CreditCardValidatorAPI.exceptions.InvalidCardNumberException;
import io.github.mahirahman.CreditCardValidatorAPI.model.Luhn;
import io.github.mahirahman.CreditCardValidatorAPI.model.Numeric;

@Path("/validates")
@Produces(MediaType.APPLICATION_JSON)
public class Validate {

	// GET method that validates a credit card using an instance of the Luhn class
	// localhost:8080/CreditCardValidatorAPI/v1/validates?card_num={cardNum}
	@GET
	public String validateCard(@QueryParam("card_num") String cardNum) {
		
		// Handle non-numeric values
		// e.g) "", " ", " 123", "test", "!@123", null
		if (!Numeric.isNumeric(cardNum)) {
			throw new InvalidCardNumberException(Response.Status.BAD_REQUEST,
					"Card number is not numeric. Please input a numeric value.");
		}
		// Handle negative values
		// e.g) "-123", "0", "-0"
		else if (Long.parseLong(cardNum) <= 0) {
			throw new InvalidCardNumberException(Response.Status.BAD_REQUEST,
					"Card number is not a positive number. Please input a non-negative value.");
		}
		
		Luhn checkLuhn = new Luhn();
		// Returns JSON response
		return Json.createObjectBuilder()
			// Add data to the JSON object
			.add("Card Number", Long.parseLong(cardNum))
			.add("Valid", checkLuhn.luhnAlgorithm(cardNum))
			.build().toString();
		}
}
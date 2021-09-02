// Credit Card issuer category endpoint

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


@Path("/issuer-category")
@Produces(MediaType.APPLICATION_JSON)
public class IssuerCategory {
	
	private static char identifier;
	private static String issuer;
	
	// GET method that produces the Major Industry Identifier (MII) and Issuer Category
	// localhost:8080/CreditCardValidatorAPI/v1/issuer-category?card_num={cardNum}
	@GET
	public String issuerCategory(@QueryParam("card_num") String cardNum) {
		
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
		// Handle if the card is not valid value
		// e.g) "30286572326402"
		Luhn checkLuhn = new Luhn();
		if (!checkLuhn.luhnAlgorithm(cardNum)) {
			throw new InvalidCardNumberException(Response.Status.NOT_FOUND,
					"Card number is not a valid number. Please use the validate endpoint to see if value is valid.");
		}
		
		// Major Industry Identifier
		identifier = cardNum.charAt(0);

		// Returns JSON response
		return Json.createObjectBuilder()
			// Add data to the JSON object
			.add("Card Number", Long.parseLong(cardNum))
			.add("Major Industry Identifier", Character.getNumericValue(identifier))
			.add("Issuer Category", getIssuerCategory(identifier))
			.add("Valid", checkLuhn.luhnAlgorithm(cardNum))
			.build().toString();
	}
	
	// Returns the issuer category based on the identifier parameter
	// Issuer categories sourced from ISO/IEC 7812
	public String getIssuerCategory(char identifier) {
		
		switch(identifier) {
		  case '0':
			  issuer = "ISO/TC 68 and other future industry assignments";
			  break;
		  case '1':
			  issuer = "Airlines";
			  break;
		  case '2':
			  issuer = "Airlines and other future industry assignments";
			  break;
		  case '3':
			  issuer = "Travel and entertainment and banking/financial";
			  break;
		  case '4':
			  issuer = "Banking and financial";
			  break;
		  case '5':
			  issuer = "Banking and financial";
			  break;
		  case '6':
			  issuer = "Merchandising and banking/financial";
			  break;
		  case '7':
			  issuer = "Petroleum and other future industry assignments";
			  break;
		  case '8':
			  issuer = "Healthcare, telecommunications and other future industry assignments";
			  break;
		  case '9':
			  issuer = "National assignment";
			  break;
		  default:
			  issuer = "Unknown";
		}
		return issuer;
	}
}

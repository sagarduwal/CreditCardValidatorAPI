// Credit Card issuer category endpoint

package io.github.mahirahman.CreditCardValidatorAPI.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.json.Json;
import javax.json.JsonObject;

@Path("/issuer-category")
@Produces(MediaType.APPLICATION_JSON)
public class IssuerCategory {
	
	private static char identifier;
	private static String issuer;
	
	// GET method that produces the Major Industry Identifier (MII) and Issuer Category
	// localhost:8080/CreditCardValidatorAPI/v1/issuer-category?card_num={cardNum}
	@GET
	public String issuerCategory(@QueryParam("card_num") long cardNum) {
		
		identifier = String.valueOf(cardNum).charAt(0);

		// Add data to the JSON object
		JsonObject response = Json.createObjectBuilder()
			.add("Card Number", cardNum)
			.add("Major Industry Identifier", Character.getNumericValue(identifier))
			.add("Issuer Category", getIssuerCategory(identifier))
			.build();

		// Returns JSON response
		return response.toString();

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

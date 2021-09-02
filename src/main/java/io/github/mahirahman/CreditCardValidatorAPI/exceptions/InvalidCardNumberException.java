// Changes the status code to 404 and returns the error message in JSON format

package io.github.mahirahman.CreditCardValidatorAPI.exceptions;

import javax.json.Json;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class InvalidCardNumberException extends WebApplicationException {

	private static final long serialVersionUID = -7788680161618589775L;

	public InvalidCardNumberException(Response.Status status_code, String message) {
        super(Response.status(status_code)
            .entity(Json.createObjectBuilder()
            		.add("Error Code", status_code.getStatusCode())
            		.add("Status", status_code.getReasonPhrase())
            		.add("Error Message", message)
            		.build().toString())
            .type(MediaType.APPLICATION_JSON)
            .build());
    }
}
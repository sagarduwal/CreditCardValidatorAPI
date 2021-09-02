package io.github.mahirahman.CreditCardValidatorAPI.model;

public class Numeric {
	
	// Check if a string is numeric
	public static boolean isNumeric(String strNum) {
	    try {
	    	Long.parseLong(strNum);
	    }
	    catch (NumberFormatException ex) {
	    	return false;
	    }
	    return true;
	}

}



//Check if a credit card is valid using the Luhn algorithm
//Authors: Mahi Rahman, mahi.rahman@student.uts.edu.au
//Copyright 2020

/*
Validating a card number using the Luhn algorithm simply
confirms with a high degree of probability that the digits
are correctly captured. There is a very low probability that
multiple digits are incorrect while still allowing the number
to validate. There is no guarantee the number has actually been
assigned to an account, has a sufficient balance and has not expired etc.
*/

package io.github.mahirahman.CreditCardValidatorAPI;

public class Luhn {

	private static int numOfDigits;
	private static int currDigit;
	private static int totalOdd;
	private static int totalEven;

	//Constructor to initialize the total for odd and even weights
	public Luhn() {
		totalEven = 0; //First digit is even at index 0,2,4,..
		totalOdd = 0; //Second digit is odd at index 1,3,5,..
	}

	//Implementation of the Luhn algorithm
	boolean luhnAlgorithm(String cardNum) {
		numOfDigits = cardNum.length(); //Retrieve the length of the raw card number
		String reverseCardNum = new StringBuffer(cardNum).reverse().toString(); //Reverses the raw card number

		for(int i = 0; i < numOfDigits; i++) {
			currDigit = Character.digit(reverseCardNum.charAt(i), 10); //Get the current digit at index i
			if(i % 2 == 0) {
				totalOdd += currDigit;	//Adds current digit of weight '1' to total
			}
			else {
				totalEven += currDigit * 2;	//Adds current digit of weight '2' to total
				if(currDigit >= 5) {	//Checks if it is a double digit, If so then remove 9
					totalEven -= 9;
				}
			}
		}

		//Returns boolean value corresponding to the total digits in the credit card divisible by 10
		//Ensures checksum digit is valid
	    return ((totalOdd + totalEven) % 10 == 0);
	}

}

package weekoffebruaryseven;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

public class Problem1_07Feb2022Test {
	static String number = "923456789";
	
	//Write a function that returns true if a string consists of ascending or ascending AND consecutive numbers.
//
//		Examples
//		ascending("232425") --> true
//		// Consecutive numbers 23, 24, 25
//
//		ascending("2324256") --> false
//		// No matter how this string is divided, the numbers are not consecutive.
//
//		ascending("444445") --> true
//		// Consecutive numbers 444 and 445.
//		Notes
//		A number can consist of any number of digits, so long as the numbers are adjacent to each other, and the string has at least two of them.
//
//	
	
	@Test
	void checkIfConsecutiveAssendingNumberReturnsTrue() {
		String nextValue = "10";
		String currentValue = "9";
		
		boolean result = Long.parseLong(nextValue) - Long.parseLong(currentValue) == 1;

		assertTrue(result);
	}
	
	@Test
	void checkIfConsecutiveAssendingNumberReturnsFalse() {
		String nextValue = "10";
		String currentValue = "8";
		
		boolean result = Long.parseLong(nextValue) - Long.parseLong(currentValue) == 1;

		assertFalse(result);
	}
	
	@Test
	void getNextActualValue() {
		String number = "91011";
		int startingPosition = 0;
		int substringLength = 1;
		String currentValue = number.substring(startingPosition, substringLength);
		String expected = "10";
		String actual = String.valueOf(Long.parseLong(currentValue) + 1); 
		
		assertEquals(expected, actual);
	}
	
	@Test
	void getNextValueActual() {
		String number = "47484950515253";
		int startingPosition = 0;
		int substringLength = 2;
		String currentValue = number.substring(startingPosition, substringLength);
		String expected = "48";
		
		long nextInteger = Long.parseLong(currentValue) + 1; 
		int nextIntegerLength = String.valueOf(nextInteger).length();
		String actual = number.substring(startingPosition + substringLength, startingPosition + nextIntegerLength + substringLength);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void getNextValueActualFinalSet() {
		String number = "47484950515253";
		int startingPosition = 10;
		int substringLength = 2;
		String expected = "53";
		
		String actual = number.substring( (startingPosition + substringLength) );
		System.out.println(actual);
		
		assertEquals(expected, actual);
	}
}

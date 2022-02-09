package weekoffebruaryseven;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

public class Problem2_07Feb2022Test {
/* 
	Create a function that takes an integer and outputs an n x n square solely consisting of the integer n.
*/
	
	@Test
	void buildFirstPrint() {
		int number = 0;
		String expected = "squarePatch(0) --> [";
		String actual = "squarePatch(" + number + ") --> [";
		
		System.out.println(actual);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void buildArrayString() {
		int number = 3;
		String body = "";
		int[] array = new int[number];
		
		for (int i = 0; i < number; i++) {
			array[i] = number;
		}
		
		for (int i = 0; i< number; i++) {
			
			if ( i < number -1) {
				body += "\n" + Arrays.toString(array) + ",";
			}
			
			else {
				body += "\n" + Arrays.toString(array) + "\n";
			}
		}
		String expected = "[3, 3, 3]";
		String actual = Arrays.toString(array);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void buildLastPrint() {
		String expected = "]";
		String actual = "]";
		
		System.out.println(actual);
		
		assertEquals(expected, actual);
	}
}

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Problem2_31Jan2022Test {

	@Test
	void getValue_sumOfNumbersTest() {
		char firstNumber = '1'; 
		char secondNumber = '1';
		
		String sumOfNumbers = String.valueOf((firstNumber - 48) + (secondNumber - 48));
		
		int expectedInt = Integer.parseInt(String.valueOf(firstNumber)) + Integer.parseInt(String.valueOf(secondNumber));
		String expected = String.valueOf(expectedInt);
		String actual = sumOfNumbers;
		
		assertEquals(expected, actual);
	}

	@Test
	void getValue_SingleDigitResultTest() {
		Problem2_31Jan2022.multiplyBy11("11");
		char expected = '2';
		char actual = Problem2_31Jan2022.values[1];
		
		assertEquals(expected, actual);
	}

	@Test
	void getValue_DoubleDigitResultTest() {
		Problem2_31Jan2022.multiplyBy11("19");
		char expected = '0';
		char actual = Problem2_31Jan2022.values[1];
		
		assertEquals(expected, actual);
	}

	@Test
	void carryTheOne_ValueOtherThan9() {
		Problem2_31Jan2022.multiplyBy11("19");
		char expected = '2';
		char actual = Problem2_31Jan2022.values[0];
		
		assertEquals(expected, actual);
	}

	@Test
	void carryTheOne_9NotAtIndexZero() {
		String actualResult = Problem2_31Jan2022.multiplyBy11("182");
		char expectedPosition1 = '0';
		char expectedPosition0 = '2';
		String expectedResult = "2002";
		char actualPosition0 = Problem2_31Jan2022.values[0];
		char actualPosition1 = Problem2_31Jan2022.values[1];
		
		assertTrue(actualPosition0 == expectedPosition0 &&
				actualPosition1 == expectedPosition1 &&
				actualResult.equals(expectedResult)
				);
	}

	@Test
	void carryTheOne_9AtZeroIndex() {
		String actualString = Problem2_31Jan2022.multiplyBy11("91");
		char expected = '0';
		char expected1AddedBeforeIndexZero = '1';
		char actual = Problem2_31Jan2022.values[0];
		char oneAddedSuccessfullyCheck = actualString.charAt(0);
		
		assertTrue(expected == actual && expected1AddedBeforeIndexZero == oneAddedSuccessfullyCheck);
		
	}

}

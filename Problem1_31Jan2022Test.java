import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Problem1_31Jan2022Test {

	@Test
	void integersProcessCorrectlyTest() {
		Object[] integersOnlyArrayProcessesSuccessfully = {1, 20, 33, 47, 506, 6123, 78962, 876542};
		int[] expected = {1, 20, 33, 47, 506, 6123, 78962, 876542};
		int[] result = Problem1_31Jan2022.getResult(integersOnlyArrayProcessesSuccessfully);
		assertArrayEquals(expected, result);
		
		integersOnlyArrayProcessesSuccessfully = null;
	}
	
	@Test
	void onlyIntegersAndStringsAllowedInArray() {
		Object[] objectArray = {(byte) 0011, (short) 20, (int) 1, (long) 45685354211654L, (float) 3.14f, (double) 12.33D, (boolean) true, (char) 'a', (String) "Hello"};
		
		Problem1_31Jan2022.getResult(objectArray);
		String expected = "Only Integer and String Objects allowed";
		String actual = Problem1_31Jan2022.message;
		assertTrue(actual.contains(expected));
		
		objectArray = null;
	}

	@Test
	void noIntegersReturnsMessageTest() {
		Object[] noIntArray = {"test", "help", "1", "323q4a;sdflkj"};
		Problem1_31Jan2022.getResult(noIntArray);
		String expected = "There are no integers in the array.";
		String actual = Problem1_31Jan2022.message;
		assertEquals(expected, actual);
		
		noIntArray = null;
	}

	@Test
	void duplicatesRemovedTest() {
		Object[] array = {1, 2, 1, 2, 1, 2, 2, 1};
		int[] expected = {1, 2};
		int[] result = Problem1_31Jan2022.getResult(array);
		assertArrayEquals(expected, result);
		
		array = null;
	}

	@Test
	void mixedArrayOfStringsAndIntegersOnlyReturnsIntegersTest() {
		Object[] mixedArray = {1, 2, "aasf", "1", "123", 123, 2};
		int[] expected = {1, 2, 123};
		int[] result = Problem1_31Jan2022.getResult(mixedArray);
		assertArrayEquals(expected, result);
		
		mixedArray = null;
	}

	@Test
	void originalOrderMaintainedTest() {
		Object[] mixedArray = {1, 5, "aasf", "1", "123", 123, 2, 2};
		int[] expectedOrder = {1, 5, 123, 2};
		int[] actualOrder = Problem1_31Jan2022.getResult(mixedArray);
		
		assertArrayEquals(expectedOrder, actualOrder);

		
		mixedArray = null;
	}

}

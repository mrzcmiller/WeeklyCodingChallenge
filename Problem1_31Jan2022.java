import java.util.*;

public class Problem1 {
	
//	Problem 1. Filter Out Strings from an Array

//	Notes
//	Zero is a non-negative integer.
//	The given array only has integers and strings.
//	Numbers in the array should not repeat.
//	The original order must be maintained.
	
//	Create a function that takes an array of non-negative integers and strings and returns a new array without the strings.
	
	/* 
	 * The getResult method processes an Object array provided as an argument and returns an Object[] of Integer objects
	 * A List of Object types is created to accommodate an uncertain number of Integer objects in any given array
	 * A for loop then iterates through the array checking to see if the object is an instance of the Integer class and
	 * if it is, adds it to the List. The list is then converted to and stored in an Object[] and set to null for garbage 
	 * collection.
	 * The Object[] is then returned to the main method
	 */
	public static Object[] getResult(Object[] array) {
		List<Object> arrayItems = new ArrayList<Object>(); // Create a List with type Object to stores Integer objects
		
		for (Object item : array) { // Loop through the array provided as an argument
			if(item instanceof Integer) { // Check to see if the current object is an instance of the Integer class
				arrayItems.add(item); // If the object is an Integer object, add it to the arrayItems List
			}
		}
		Object[] result = arrayItems.toArray(); // Convert the list to an array and store it as an Object[]
		arrayItems = null; // Set the arrayItems list to null for garbage collection
		
		return result; // Return the result to the main method
	}

	/* 
	 * The main method sets an array of String and Integer objects, calls the getResult method with the array
	 * as an argument, stores the results in an Object[] variable and prints the array as a string
	 */
	public static void main(String[] args) {
//		Object[] array = {1, 2, "a", "b"}; // First array option
		Object[] array = {1, "a", "b", 0, 15}; // Second array option
//		Object[] array = {1, 2, "aasf", "1", "123", 123}; // Third array option
		
		
		Object[] result = getResult(array); // Call getResult with an array as the argument and store the results as an Object[]
		System.out.println(Arrays.toString(result)); // Print the newly created array as a string.
	}

}

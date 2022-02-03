import java.util.*;

public class Problem1_31Jan2022 {
	
//	Problem 1. Filter Out Strings from an Array

//	Notes
//	Zero is a non-negative integer.
//	The given array only has integers and strings.
//	Numbers in the array should not repeat.
//	The original order must be maintained.
	
//	Create a function that takes an array of non-negative integers and strings and returns a new array without the strings.
	
	/* 
	 * The getResult method processes an Object array provided as an argument and returns an int[]
	 * A List of Integer types is created to accommodate an uncertain number of Integer objects in any given array
	 * A for loop then iterates through the array checking to see if the object is an instance of the Integer class and
	 * if it is, navigates a second for loop to see if that value alread exits in the List. If the second for loop 
	 * completes without finding an equal value, it adds the current value to the List. If a duplicate is found, a 
	 * 'duplicate' boolean is set to true and the item is not added to the list. Once the loops complete, the initial array
	 * is set to null, and integer array is created for the size of the list, a for loop iterates through the list and stores
	 * the integer value at each position into the int[] corresponding position. The List is set to null for garbage 
	 * collection and the int[] is returned to the main method.
	 */
	public static int[] getResult(Object[] array) {
		List<Integer> arrayItems = new ArrayList<Integer>(); // Create a List with type Object to stores Integer objects
		boolean duplicate = false; // Used to avoid ConcurrentModificationException by delaying List modification until after the loop completes
		
		for (Object item : array) { // Loop through the array provided as an argument
			
			/* 
			 * Check if array is empty and if so, add the current item to the arrayItems
			 * This is necessary to avoid the initially null list from bypassing the inner for loop which 
			 * traverses the arrayItems List
			 */
			if ( arrayItems.isEmpty() ) {
				arrayItems.add( (Integer) item ); // add Integer object to arrayItems ArrayList
				continue;
			}
			
			if(item instanceof Integer && item != null) { // Check to see if the current object is an instance of the Integer class
				
				for ( Integer integer : arrayItems ) { // Iterate through arrayItems to check if the current value is already present
					
					if ( integer.intValue() == Integer.valueOf((Integer) item) ) {
						duplicate = true; // If value is already present, set duplicate property to true
						break; // Exit the current loop 
					}
					
					else {
						duplicate = false; // Set the duplicate property to false and continue to the next integer
						continue;
					}
					
				}
				
				if (!duplicate) {
					arrayItems.add((Integer) item); // Once the loop is left, if 'duplicate' is still false, item is added
				}
			}

		}
		
		array = null; // Prepare array argument for garbage collection
		int[] intArray = new int[arrayItems.size()]; // Create int[] with size equal to the size of arrayItems ArrayList
		
		// Iterate through the ArrayList and store each Integer value in the int[]
		for ( int i = 0; i < intArray.length; i++ ) {
			intArray[i] = arrayItems.get(i);
		}
		
		arrayItems = null; // Set the arrayItems list to null for garbage collection
		
		return intArray; // Return the result to the main method
	}

	/* 
	 * The main method sets an array of String and Integer objects, calls the getResult method with the array
	 * as an argument, stores the results in an Object[] variable and prints the array as a string
	 */
	public static void main(String[] args) {
//		Object[] array = {1, 2, "a", "b"}; // First array option
//		Object[] array = {1, "a", "b", 0, 15}; // Second array option
		Object[] array = {1, 2, "aasf", "1", "123", 123, 2}; // Third array option
		
		
		int[] result = getResult(array); // Call getResult with an array as the argument and store the results as an Object[]
		System.out.println(Arrays.toString(result)); // Print the newly created array as a string.
	}

}

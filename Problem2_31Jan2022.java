
public class Problem2_31Jan2022 {
	static String number = "9473745364784876"; // Number to be multiplied by 11
	static char[] values = new char[number.length()]; // Array to hold values in case they need to be incremented
	static boolean needsLeadingOne = false; // Boolean which will add a leading 1 in front of the array should an
											// increment be necessary on index 0

	/*
	 * This method will store the first number at index 0 of the values array and
	 * then enter a loop for calculation The loop takes the first two numbers in the
	 * number being multiplied and passes them as arguments, along with the current
	 * index value to the "getValue()" method. Once the loop completes, the values[]
	 * and needsLeadingOne boolean check are passed as arguments to the
	 * buildResultString method which returns the string of the final calculation.
	 * That string is returned to the Main method to be printed out.
	 */
	public static String multiplyBy11(String positiveNumber) {
		values[0] = positiveNumber.charAt(0); // Set first number to index 0

		// increment through the provided number and send the current index position,
		// it's value, and the next position's value to be calculated
		for (int valuesArrayIndex = 0; valuesArrayIndex < positiveNumber.length() - 1; valuesArrayIndex++) {
			getValue(positiveNumber.charAt(valuesArrayIndex), positiveNumber.charAt(valuesArrayIndex + 1),
					valuesArrayIndex);
		}

		String result = buildResultString(values, needsLeadingOne); // Pass values[] and leading 1 requirement check to
																	// method and store the result

		return result; // Return final value to the main method
	}

	/*
	 * getValue method takes 3 arguments (two values and the current index position
	 * for the values[] The first step performs the addition of the two values and
	 * stores it as a string sumOfNumbers The value is then checked to see if the
	 * value is greater than 9 by checking if the length is greater than 1. If it
	 * is, the value of the char in position 1 of sumOfNumbers is added to the
	 * values[] and the carryTheOne method is called to increment the preceding
	 * number. If the number is 9 or less, the number is added to the values[] and
	 * the method is complete
	 */
	public static void getValue(char firstNumber, char secondNumber, int index) {
		String sumOfNumbers = String.valueOf((firstNumber - 48) + (secondNumber - 48)); // Add the numbers together
																						// using the ascii values -48

		// Check if the result is a single or double digit value by seeing if length is
		// greater than 1
		if (sumOfNumbers.length() > 1) {
			values[index + 1] = sumOfNumbers.charAt(1); // Store the ones digit to the array
			carryTheOne(index); // Call the carryTheOne method and pass in the index value
		}

		else {
			values[index + 1] = sumOfNumbers.charAt(0); // Store the value
		}
	}

	/*
	 * carryTheOne method takes an index as an argument, increments the value at
	 * that position by one, checks to see if doing so requires incrementation of
	 * the previous value, and if at position 0 sets the needsLeadingOne property to
	 * true.
	 */
	public static void carryTheOne(int index) {

		/*
		 * Check to see if the position being checked is index 0 and the value of the
		 * index is 9 This is used to set the needsLeadingOne property to true instead
		 * of shifting the array
		 */
		if (index == 0 && values[index] == '9') {
			values[index] = '0'; // Set the value in position 0 to '0'
			needsLeadingOne = true; // Set the property to true so a 1 will appear at the beginning of the number
									// string
			return; // Leave the method
		}

		// If the value at the index position is not nine, increment the value
		else if (values[index] != '9') {
			values[index]++;
		}

		/*
		 * The else statement will cover incrementation in which the index position is
		 * not 0. The value will be set to '0' and the method will recurse with the
		 * previous position. This is done to accommodate for instances in which
		 * incrementing the value of the current index causes the previous index to be
		 * incremented. Should all previous indexes be 9s, the if statement will set the
		 * needsLeadingOne property and add a '1' before the string of values from the
		 * array
		 */
		else {
			values[index] = '0'; // Set the value to '0'
			carryTheOne(index - 1); // Call the method recursively with the previous index as the argument
		}
	}

	/*
	 * buildResultString method takes two arguments, the array of values and whether
	 * or not a leading one is required. An empty string is created. needsLeadingOne
	 * is checked and if true, appends a '1' to the string, otherwise, is bypassed.
	 * A for loop then appends each index position's value to the string. To
	 * accommodate for any possibility of a space, spaces are removed from the
	 * string. The final number of the original number provided is then appended to
	 * the end of the string and the string is returned to the multiplyBy11 method.
	 */
	public static String buildResultString(char[] values, boolean needsLeadingOne) {
		String result = ""; // Empty string creation

		if (needsLeadingOne) {
			result += '1'; // Append a '1' if needsLeadingOne is true
		}

		for (char value : values) {
			result += value; // Loop through the values[] and append each value to the string
		}

		result.replace(" ", ""); // Remove any spaces from the string
		result += number.charAt(number.length() - 1); // Append the final number from the number being multiplied

		return result; // Return result to multiplyBy11 method
	}

	/*
	 * The main method prints out: 
	 * The number being multiplied by 11
	 * The results from multiplyBy11Test method
	 * The result from multiplyBy11 method
	 * A boolean value of whether the values returned are equal (done to ensure that the created method works)
	 * 
	 * The main methods calls both methods using the number to be multiplied as an argument
	 */
	public static void main(String[] args) {
		System.out.println("Number:              " + number);
		String testResult = multiplyBy11Test(number);
		String methodResult = multiplyBy11(number);

		System.out.println("Test result:       " + testResult.toString());
		System.out.println("Method result:     " + methodResult.toString());
		System.out.println("Checking accuracy: " + testResult.equals(methodResult));

	}

	/* 
	 * multiplyBy11Test method is used to ensure that the method being created works as 
	 * well as a visual queue as to what may not be working should they not match. The final number
	 * provided in the list was too large to parse, so numbers greater than 18 digits just returns a
	 * string explaining that the number cannot be tested. 
	 * It checks to see that the number is less than 19 digits and if so, parses the string into a long,
	 * multiplies that long by 11, stores that value as a string, and returns it to the main method.
	 */
	public static String multiplyBy11Test(String positiveNumber) {
		if (positiveNumber.length() < 19) { // Check if number is less than 19 digits in length
			long number = Long.parseLong(positiveNumber); // Parse the string to a long and store the value
			String numberAsString = String.valueOf(number * 11); // Multiply the value by 11, convert it to a string, and store it
			return numberAsString; // Return the result to the main method
		}
		return "Number too large to test"; // If the number is greater than 18 digits, return message that number is too large to test
	}
}

package weekoffebruaryseven;

import java.util.Scanner;

public class Problem1_07Feb2022 {


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter a number to test: ");

		Problem1_07Feb2022 application = new Problem1_07Feb2022();
		NumberChecker numberChecker = application.new NumberChecker(scanner.nextLine());
		System.out.println(numberChecker.checkNumber());

		scanner.close();
	}


public class NumberChecker {
	private String number;
	private boolean isConsecutiveAssendingNumber;
	private int startingPosition = 0;
	private int substringLength = 1;

	public boolean isConsecutiveAssendingNumber() {
		return isConsecutiveAssendingNumber;
	}

	public void setConsecutiveAssendingNumber(boolean isConsecutiveAssendingNumber) {
		this.isConsecutiveAssendingNumber = isConsecutiveAssendingNumber;
	}

	public int getStartingPosition() {
		return startingPosition;
	}

	public void setStartingPosition(int startingPosition) {
		this.startingPosition = startingPosition;
	}

	public int getSubstringLength() {
		return substringLength;
	}

	public void setSubstringLength(int substringLength) {
		this.substringLength = substringLength;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public NumberChecker(String number) {
		super();
		setNumber(number);
	}

	private boolean checkNumber() {
//		System.out.println("Entering checkNumber()");

		while ((startingPosition + substringLength) < number.length()) {

			String currentValue = number.substring(startingPosition, substringLength + startingPosition);
//			System.out.println("currentValue: " + currentValue);

			if (currentValue.length() > (number.length() / 2)) {
				return false;
			}

			String nextValue = getNextValue(currentValue);
//			System.out.println("nextValue: " + nextValue);

			isConsecutiveAssendingNumber = checkIfConsecutiveAssendingNumber(nextValue, currentValue);
//			System.out.println("consecutive: " + isConsecutiveAssendingNumber);

			setup(isConsecutiveAssendingNumber, nextValue);
//			System.out.println( (startingPosition + substringLength) + " < " + number.length() + ": " + ((startingPosition + substringLength) < number.length()) );
		}
		return isConsecutiveAssendingNumber;
	}

	private String getNextValue(String currentValue) {
//		System.out.println("Entering getNextValue()");
		long nextInteger = Long.parseLong(currentValue) + 1;
		int nextIntegerLength = String.valueOf(nextInteger).length();
		String nextValue;

		if (((startingPosition + substringLength) + (nextIntegerLength + 1)) > number.length()) {
//			System.out.println(number + ".substring(" + startingPosition + " + " + substringLength + ")");
			nextValue = number.substring((startingPosition + substringLength));
		}

		else {
//			System.out.println(number + ".substring(" + startingPosition + " + " + substringLength + ", " + nextIntegerLength + " + " + substringLength + ")");
			nextValue = number.substring(startingPosition + substringLength,
					startingPosition + nextIntegerLength + substringLength);
		}

		return nextValue;
	}

	private boolean checkIfConsecutiveAssendingNumber(String nextValue, String currentValue) {
//		System.out.println("Entering checkIfConsecutiveAssendingNumber()");
		boolean result = Long.parseLong(nextValue) - Long.parseLong(currentValue) == 1;
		return result;
	}

	private void setup(boolean isConsecutiveAssendingNumber, String nextValue) {
//		System.out.println("Entering setup()");
		if (isConsecutiveAssendingNumber) {
			startingPosition += substringLength;
			substringLength = nextValue.length();
		}

		else {
			startingPosition = 0;
			substringLength++;
		}
	}
}
}
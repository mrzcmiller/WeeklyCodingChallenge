package weekoffebruaryseven;

import java.util.Arrays;

public class Problem2_07Feb2022 {
	
	public static void main(String[] args) {
		int number = 5;
		System.out.println(buildSquare(number));
	}

	
	public static String buildSquare(int number) {
		String firstLine = "squarePatch(" + number + ") --> [";
		String body = "";
		String lastLine = "]";
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
		
		String result = firstLine + body + lastLine;
		return result;
	}
}

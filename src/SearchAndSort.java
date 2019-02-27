import java.util.ArrayList;
import java.util.Scanner;

public class SearchAndSort {
	
	/**
	 * Program execution starts here.
	 * 
	 * @param args
	 */
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Which algorithm would you like to execute? \nOptions: bubble, selection, insertion, merge, linear, binary, quit");
		String algorithm = in.nextLine();
		algorithm = algorithm.toLowerCase();
		boolean validInput = false;
		do {
			if (algorithm.matches("bubble") || algorithm.matches("selection") || algorithm.matches("insertion") || algorithm.matches("merge") || algorithm.matches("linear") || algorithm.matches("binary") || algorithm.matches("quit")) {
				validInput = true;
			} else {
				System.out.println("Please pick one of the options \nOptions: bubble, selection, insertion, merge, linear, binary, quit");
				algorithm = in.nextLine();
				algorithm = algorithm.toLowerCase();
			}
		} while (!validInput);
		if (!algorithm.matches("quit")) {
			System.out.println("Which type of data would you like to use? \nOptions: integers, strings");
			String datatype = in.nextLine();
			datatype = datatype.toLowerCase();
			validInput = false;
			do {
				if (datatype.matches("integers") || datatype.matches("strings")) {
					validInput = true;
				} else {
					System.out.println("Please pick one of the options \nOptions: integers, strings");
					datatype = in.nextLine();
					datatype = datatype.toLowerCase();
				}
			} while (!validInput);
			System.out.println("How will it be stored? \nOptions: array, list");
			String storage = in.nextLine();
			storage = storage.toLowerCase();
			validInput = false;
			do {
				if (storage.matches("array") || storage.matches("list")) {
					validInput = true;
				} else {
					System.out.println("Please pick one of the options \nOptions: array, list");
					storage = in.nextLine();
					storage = storage.toLowerCase();
				}
			} while (!validInput);
			System.out.println("Enter your data (Ex. 1,2,3,4,5): ");
			String values = in.nextLine();
			values = values + ",";
			int commaCount = 0;
			for (int i = 0; i < values.length(); i++) {
				if (values.charAt(i) == ',') {
					commaCount++;
				}
			}
			if (storage.matches("array") && datatype.matches("integers")) {
				String[] temp = values.split(",");
				int[] arrayValues = new int[commaCount];
				for (int i = 0; i < temp.length; i++) {
					arrayValues[i] = Integer.valueOf(temp[i]);
					System.out.println(arrayValues[i]);
				}
				
			} else if (storage.matches("array") && datatype.matches("strings")) {
				String[] arrayValues = values.split(",");
				for (int i = 0; i < arrayValues.length; i++) {
					System.out.println(arrayValues[i]);
				}
			} else if (storage.matches("list") && datatype.matches("integers")) {
				ArrayList<Integer> arrayValues = new ArrayList<Integer>();
			} else {
				ArrayList<String> arrayValues = new ArrayList<String>();

			}
		} else {
			System.out.println("Thank you!");
		}
		in.close();
	}
	
	//code
}
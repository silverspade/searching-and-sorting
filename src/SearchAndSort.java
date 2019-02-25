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
			System.out.println("How will it be stored? \nOptions: array, list");
			String storage = in.nextLine();
			storage = storage.toLowerCase();
			System.out.println("Enter your data (Ex. 1,2,3,4,5): ");
			String values = in.nextLine();
			System.out.println("Algorithm: " + algorithm);
			System.out.println("Datatype: " + datatype);
			System.out.println("Storage: " + storage);
			System.out.println("Data: " + values);
		} else {
			System.out.println("Thank you!");
		}
		in.close();
	}
	
	//code
}
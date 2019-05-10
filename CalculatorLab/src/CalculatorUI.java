/**
 * Provides an user interface for Calculator
 * @authors Hunter Damron and Dennis Perea
 * //CalculatorUI.java
 * //Honor Code: On our honor, we did not give or 
 * 		receive any help on this assignment
 */
import java.util.Scanner;

public class CalculatorUI {
	public static void main(String[] args) throws Exception {
		final String HELP = "Help.", //TODO Help message (reached by typing h or help)
				WELCOME = "Welcome.\n> "; //TODO Welcome message
		Calculator calc;
		String input;
		Scanner in = new Scanner(System.in);
		
		System.out.print(WELCOME);
		while(true) {
			input = in.nextLine();
			if(input.contains("q") || input.contains("Q")) 
				break;
			if(input.contains("h") || input.contains("H"))
				System.out.println(HELP);
			else {
				calc = new Calculator(input);
				System.out.println(calc.solve());
			}
			System.out.print("Enter another expression to be solved or 'q' to quit.\n> ");
		}
		in.close();
		System.out.println("Goodbye");
	}
}

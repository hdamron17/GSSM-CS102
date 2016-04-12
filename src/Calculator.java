////////////**********WHOA YOU'RE READING THIS DENNIS!!!!!!**********//////////////

/**
 * Calculates an expression using basic operators
 * @author Hunter Damron and Dennis Perea
 * //Calculator.java
 * //Honor Code: On our honor, we did not give or 
 * 		receive any help on this assignment
 */
import java.util.Stack;

public class Calculator {
	private String[] terms;
	private Stack<Integer> numTerms;
	private Stack<String> opTerms;
	private final String NUMS = "0123456789";
	private final String OPS = "+-*/^ ()";
	
	public Calculator(String expression) {
		terms = expression.split(" ");
		numTerms = new Stack<Integer>();
		opTerms = new Stack<String>();
	}
	
	public double solve() {
		
		
		//TODO Solve the expression from String array
		return 0.0;
	}
}
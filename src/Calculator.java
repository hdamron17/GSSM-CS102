/**
 * Calculates an expression using basic operators
 * @authors Hunter Damron and Dennis Perea
 * //Calculator.java
 * //Honor Code: On our honor, we did not give or 
 * 		receive any help on this assignment
 */
import java.util.Stack;

public class Calculator {
	private String expression;
	private String[] terms;
	private Stack<Integer> numTerms;
	private Stack<String> opTerms;
	private final String NUMS = "0123456789";
	private final String OPS = "+-*/^ ()";
	
	public Calculator(String expression) {
		this.expression = expression;
		terms = expression.split(" ");
		numTerms = new Stack<Integer>();
		opTerms = new Stack<String>();
	}
	
	/**
	 * Checks the equation to see if it's syntax is 
	 * 		correct
	 */
	private void check() {
		
		//TODO Check possible issues in expression 
		//and throw various Exceptions
		//!!!Comment each check!!!
	}
	
	/**
	 * Solves the given equation using Stacks
	 * @return Returns the double value of the expression
	 */
	public double solve() {
		byte priority = 0;
		
		check();
		
		//TODO Solve the expression from String array
		return 0.0;
	}
	public String toString() {
		return "Calculator[" + expression + " = ?]";
	}
}
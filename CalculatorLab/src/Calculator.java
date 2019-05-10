/**
 * Calculates an expression using basic operators
 * @authors Hunter Damron and Dennis Perea
 * //Calculator.java
 * //Honor Code: On our honor, we did not give or 
 * 		receive any help on this assignment
 */

//###### See CalculationBrainstorm.txt ########//
import java.util.Stack;

public class Calculator {
	private String expression;
	private String[] terms;
	private Stack<Double> numTerms;
	private Stack<String> opTerms;
	private final String NUMS = "0123456789";
	private final String OPS = "+-*/^ ()";
	
	public Calculator(String expression) {
		this.expression = expression;
		terms = expression.split(" ");
		numTerms = new Stack<Double>();
		opTerms = new Stack<String>();
	}
	
	/**
	 * Checks the equation to see if it's syntax is 
	 * 		correct
	 *  
	 */
	private String check() {
		
		//TODO Check possible issues in expression 
		//and throw various Exceptions
		//!!!Comment each check!!!
		
		
		//Checking Parentheses Number
		//Counts total of left and right bracket
		int leftBracket = 0;
		int rightBracket = 0;
		for (int i = 0; i < terms.length; i++)
		{
			if (terms[i].equals("("))
				leftBracket++;
			
			if (terms[i].equals(")"))
				rightBracket++;
		}
		
		if (leftBracket != rightBracket)
			return "Incorrect Bracket Total";
		//
		//
		
		
		//
		//Checking for correct bracket formatting 
		String line = terms.toString();
		Stack <String> brack = new Stack<String>();

		//Make a stack with only the brackets in order
		for (int i = 0; i < terms.length; i++)
		{
		if (terms[i].equals("("))
			brack.push("(");
		
		if (terms[i].equals(")"))
			brack.pop();
		}		
		if (!brack.isEmpty())
			return "Incorrect Bracket Order";
		//
		//
		
		//Check to see if the character is legal
		String listOf = "" + NUMS + OPS;
		boolean legal = false;
		
		    for (int j = 0; j < terms.length; j++)
		    {
		    	for (int i = 0; i < listOf.length();i++)
		    	{
		    		if (terms[j].equals(listOf.charAt(i)))
		    				legal = true;
		    	}
		    }
		
		if (legal == false)
			return "Illegal Character";
		
		return "";
	}
	
	/**
	 * Solves the given equation using Stacks
	 * @return Returns the double value of the expression
	 * @throws Exception 
	 */
	public double solve() throws Exception {
		//With the exception of parentheses, priority = OPS.indexOf(op) / 2;
		//because of integer division
		int priority = -1, index = 0, foundPriority;
		double a, b;
		String op;
		
		String errMsg = check();
		if(!errMsg.equals(""))
			throw new Exception(errMsg);
		
		while(index < terms.length && !opTerms.isEmpty()) {
			if(index > terms.length) {
				foundPriority = -1;
				backward: while(priority >= foundPriority) {
					if(opTerms.isEmpty())
						break backward;
					op = opTerms.peek();
					if(priority(op) < priority)
						break backward;
					opTerms.pop();
					b = numTerms.pop();
					a = numTerms.pop();
					numTerms.push(operate(a, b, opTerms.pop()));
				}
			} else if(isNumerical(terms[index])) {
				numTerms.push(Double.parseDouble(terms[index]));
				index++;
			} else if (OPS.contains(terms[index])) {
				foundPriority = priority(terms[index]);
				if(foundPriority > priority) {
					opTerms.push(terms[index]);
					priority = foundPriority;
					index++;
				} else {
					backward: while(priority >= foundPriority) {
						if(opTerms.isEmpty())
							break backward;
						op = opTerms.peek();
						if(priority(op) < priority)
							break backward;
						opTerms.pop();
						b = numTerms.pop();
						a = numTerms.pop();
						numTerms.push(operate(a, b, opTerms.pop()));
					}
				}
			} else 
				throw new Exception("Illegal Character");
		}
		
		
		//TODO Solve the expression from String array
		return 0.0;
	}
	
	/**
	 * Determines if a String is numerical
	 * @param num Number to be tested
	 * @return Returns true if numerical
	 */
	private boolean isNumerical(String num) {
		return NUMS.contains(num.substring(0,1));
	}
	
	private int priority(String op) {
		return OPS.indexOf(op) / 2;
	}
	
	public String toString() {
		return "Calculator[" + expression + " = ?]";
	}
	
	private double operate(double a, double b, String op) {
		switch(op) {
		case "+": return a + b;
		case "-": return a - b;
		case "*": return a * b;
		case "/": return a / b;
		case "^": return Math.pow(a, b);
		}
		throw new NumberFormatException("Unknown operator");
	}
}
package Algorithms.MathAlgorithms;

import java.util.Stack;

public class StringCalculator {

	private String expression;

	public StringCalculator(String expression) {
		this.expression = expression;
	}

	public Object calculate() {
		double value = calculateRPN(expressionToRPN(expression));
		// TODO value / delta where delta is size of window
		if (value % 1 == 0) {
			return (int) value;
		} else {
			return value;
		}

	}

	private String expressionToRPN(String expression) {
		String resultStr = "";
		Stack<Character> stack = new Stack<>();
		int priority;
		for (int i = 0; i < expression.length(); ++i) {
			//Unary chek
			if ((expression.charAt(i) == '-' && (i == 0)) || 
					((expression.charAt(i) == '-') && (expression.charAt(i - 1) != ')') &&
					(expression.charAt(i - 1) < '0' || expression.charAt(i - 1) > '9'))) {
				priority = 0;
			} else {
				priority = getPriority(expression.charAt(i));
			}
			if (priority == 0) {
				resultStr += expression.charAt(i);
			} else if (priority == 1) {
				stack.push(expression.charAt(i));
			} else if (priority > 1) {
				resultStr += " ";
				while (!stack.empty() && getPriority(stack.peek()) >= priority) {
					resultStr += stack.pop() + " ";
				}
				stack.push(expression.charAt(i));
			} else if (priority == -1) {
				//TODO exeption
				while (getPriority(stack.peek()) != 1) {
					resultStr += " " + stack.pop();
				}
				stack.pop();
			}
		}
		while (!stack.empty()) {
			resultStr += " " + stack.pop();
		}
		return resultStr;
	}

	private byte getPriority(char operator) {
		if (operator == '(') {
			return 1;
		} else if (operator == ')') {
			return -1;
		} else if (operator == '+' || operator == '-') {
			return 2;
		} else if (operator == '*' || operator == '/') {
			return 3;
		} else {
			return 0;
		}
	}

	private double calculateRPN(String fakfaka) {
		String[] expression = fakfaka.split(" ");
		Stack<Double> stack = new Stack<>();
		for (int index = 0; index < expression.length; ++index) {
			if (!isNum(expression[index])) {
				double num1 = stack.pop();
				double num2 = stack.pop();
				stack.push(eval(num1, num2, expression[index]));
			} else {
				stack.push(Double.parseDouble(expression[index]));
			}
		}
		if (stack.isEmpty()) {
			throw new IndexOutOfBoundsException("Failed");
		} else {
			return stack.pop();
		}
	}

	private double eval(double first, double second, String operator) {
		switch (operator) {
		case "+":
			return first + second;
		case "-":
			return second - first;
		case "*":
			return first * second;
		case "/":
			// TODO equals and exept
			if (first == 0) {
				throw new NumberFormatException("Division by zero error");
				// throw new CalculatorException("Division by zero error");
			}
			return second / first;
		default:
			// throw new CalculatorException(FORMAT_ERROR);
			throw new IllegalArgumentException("Unexpected value: " + operator);
		}
	}

	// TODO fix this method
	private boolean isNum(String string) {
		try {
			Double.parseDouble(string);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	// Driver Programm
	public static void main(String[] args) {
	
		String expression = "3";
		StringCalculator e = new StringCalculator(expression);
		String resultExp = String.valueOf(e.calculate());
		System.out.println(resultExp);
	}
}

package Algorithms.MathAlgorithms;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EmptyStackException;
import java.util.Scanner;
import java.util.Stack;

import Algorithms.MathAlgorithms.exception.SuperCalculatorException;

/**
 * 
 * @author Elbek M
 */

/**
 * Calculates a string arithmetic expression in infix
 * notation using the reverse Polish notation algorithm.
 */
public class StringCalculator {

    private String expression;
    private static final int SCALE = 16;
    private static final String FORMAT_ERROR = "Incorrect format";

    StringCalculator(String expression) {
        this.expression = expression;
    }

    /**
     * Returns the result of calculating the string arithmetic
     * expression in infix notation.
     */
    String calculate() throws SuperCalculatorException {
        return calculateRPN(expressionToRPN(expression));
    }

    private String expressionToRPN(String expression) {
        boolean unary;
        int numberOfBrackets = 0;
        StringBuilder resultRpn = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); ++i) {
            unary = false;
            char token = expression.charAt(i);
            if ((token == '-' && (i == 0)) ||
                    ((token == '-') && (expression.charAt(i - 1) != ')') &&
                            (expression.charAt(i - 1) < '0' || expression.charAt(i - 1) > '9'))) {
                unary = true;
            }
            if ('(' == token) {
                stack.push(token);
                numberOfBrackets++;
            } else if (')' == token) {
                numberOfBrackets--;
                if (numberOfBrackets < 0) {
                    throw new SuperCalculatorException(FORMAT_ERROR);
                }
                while (!('(' == stack.peek())) {
                    resultRpn.append(" ").append(stack.pop());
                }
                stack.pop();
            } else if (isNumeric(token + "") || token == '.' || unary) {
                resultRpn.append(token);
            } else if (getPriority(token) > 0) {
                resultRpn.append(" ");
                while (!stack.empty() &&
                        getPriority(token) <= getPriority(stack.peek())) {
                    resultRpn.append(stack.pop()).append(" ");
                }
                stack.push(token);
            } else {
                throw new SuperCalculatorException(FORMAT_ERROR);
            }
        }
        while (!stack.empty()) {
            resultRpn.append(" ").append(stack.pop());
        }
        return resultRpn.toString();
    }

    private String calculateRPN(String rpnString) throws SuperCalculatorException {
        Stack<BigDecimal> stack = new Stack<>();
        for (String symbol : rpnString.split(" ")) {
            try {
                if (!isNumeric(symbol)) {
                    BigDecimal first = stack.pop();
                    BigDecimal second = stack.pop();
                    stack.push(evaluate(first, second, symbol));
                } else {
                    stack.push(new BigDecimal(symbol));
                }
            } catch (EmptyStackException | NumberFormatException e) {
                throw new SuperCalculatorException(FORMAT_ERROR);
            }
        }
        if (stack.isEmpty()) {
            throw new SuperCalculatorException(FORMAT_ERROR);
        } else {
            return stack.pop().stripTrailingZeros().toPlainString();
        }
    }

    private BigDecimal evaluate(BigDecimal first, BigDecimal second, String operator) {
        switch (operator) {
            case "+":
                return first.add(second);
            case "-":
                return second.subtract(first);
            case "*":
                return first.multiply(second);
            case "/":
                if (second.compareTo(BigDecimal.ZERO) == 0) {
                    throw new SuperCalculatorException("Division by zero");
                }
                return second.divide(first, SCALE, RoundingMode.HALF_UP);
            default:
                throw new SuperCalculatorException(FORMAT_ERROR);
        }
    }

    private static int getPriority(char operator) {
        if (operator == '(' || operator == ')') {
            return 0;
        } else if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/') {
            return 2;
        }
        return 3;
    }

    private boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
	
    
	// Driver Programm
	public static void main(String[] args) {
	
		Scanner in = new Scanner(System.in);
		String expression = in.next();
        in.close();
		
		StringCalculator e = new StringCalculator(expression);
		String resultExp = e.calculate();
		System.out.println(resultExp);
		
	}
}

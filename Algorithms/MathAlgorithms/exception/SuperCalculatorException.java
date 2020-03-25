package Algorithms.MathAlgorithms.exception;

/**
 * 
 * @author Elbek M
 */

public class SuperCalculatorException extends RuntimeException {
	private static final long serialVersionUID = 97314454572767837L;

	public SuperCalculatorException(String message, Throwable cause) {
        super(message, cause);
    }

    public SuperCalculatorException(String message) {
        super(message);
    }
}

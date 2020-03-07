package Algorithms.DataStructures.Stack;

/**
 * 
 * @author Elbek M
 *
 */

public class StackArray {

	private int maxSize;
	private int top;
	private int[] stackArray;
	
	public StackArray(int maxSize) {
		this.maxSize = maxSize;
		stackArray = new int[maxSize];
		top = -1;
	}
	
	public void push(int element) {
		if (isFull()) {
			System.out.println("Stack overflow!");
		} else {
			stackArray[++top] = element;
		}
	}	
	
	public int pop() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		} else {
			int value = stackArray[top--];
			return value;
		}
	}
	
	public int peek() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
			return -1;
		} else {
			return stackArray[top];
		}
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == maxSize - 1);
	}
	
	
	//Driver program
	public static void main(String[] args) {
		StackArray stack = new StackArray(5);
		stack.push(20);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(60);
		stack.push(60);
		
		
		while (!stack.isEmpty()) {
			int value = stack.pop();
			System.out.println(value);
		}
		stack.peek();
		stack.pop();
		System.out.println(stack.isEmpty());
	}
}

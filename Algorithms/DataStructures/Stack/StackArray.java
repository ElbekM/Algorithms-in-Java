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
	
	public void print() {
		if (isEmpty()) {
			System.out.println("Stack is empty");
		} else {
			while (!isEmpty()) {
				int value = pop();
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}
	
	
	//Driver program
	public static void main(String[] args) {
		StackArray stack = new StackArray(5);
		stack.push(20);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(70);
		stack.pop();
		stack.pop();
		
		stack.print();
		System.out.println(stack.isEmpty());
	}
}

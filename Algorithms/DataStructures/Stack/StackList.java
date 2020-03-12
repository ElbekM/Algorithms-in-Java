package Algorithms.DataStructures.Stack;

import Algorithms.DataStructures.LinkedList.SinglyLinkedList;

/**
 * 
 * @author Elbek M
 *
 */

public class StackList {

	private SinglyLinkedList list;
	
	public StackList() {
		list = new SinglyLinkedList();
	}
	
	public void push(int element) {
		list.addHead(element);
	}
	
	public int pop() {
		return list.deleteHead();
	}
	
	public int peek() {
		return list.get(0);
	}
	
	public boolean isEmpty() {
		return list.size() == 0;
	}
	
	public void display() {
		list.display();
	}
	
	
	//Driver program
	public static void main(String[] args) {

		StackList stack = new StackList();
		stack.push(20);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		stack.push(70);
		stack.pop();
		stack.pop();
		
		stack.display();
		System.out.println(stack.isEmpty());	
	}

}

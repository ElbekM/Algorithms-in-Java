package Algorithms.DataStructures.LinkedList;

public class Link {
	private Link next;
	private int value;
	
	public Link(int element) {
		this.value = element;
	}

	public Link getNext() {
		return next;
	}
	
	public void setNext(Link next) {
		this.next = next;
	}
	
	public int getValue() {
		return value;
	}
}

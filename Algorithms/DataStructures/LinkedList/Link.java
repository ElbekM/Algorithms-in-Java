package Algorithms.DataStructures.LinkedList;

public class Link {
	private Link next;
	private Link previous;
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
	
	public Link getPrevious() {
		return previous;
	}
	
	public void setPrevious(Link previous) {
		this.previous = previous;
	}
	
	public int getValue() {
		return value;
	}
}

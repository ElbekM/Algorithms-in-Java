package Algorithms.DataStructures.LinkedList;

/**
 * 
 * @author Elbek M
 *
 */

public class SortedList {
	
	private Link first;
	private int size;
	
	public void insert(int element) {
		Link newLink = new Link(element);
		Link previous = null;
		Link current = first;
		while (current != null && element > current.getValue()) {
			previous = current;
			current = current.getNext();
		}
		if (previous == null) {
			first = newLink;
		} else {
			previous.setNext(newLink);
		}
		newLink.setNext(current);
		size++;
	}
	
	public Link remove() {
		Link temp = first;
		first = first.getNext();
		size--;
		return temp;
	}
	
	public void clear() {
		first = null;
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public void display() {
		System.out.print("Elements: ");
		Link current = first;
		while (current != null) {
			System.out.print(current.getValue() + " ");
			current = current.getNext();
		}
		System.out.println();
	}
	
	
	//Driver program
	public static void main(String[] args) {

		SortedList list = new SortedList();
		list.insert(5);
		list.insert(3);
		list.insert(1);
		list.insert(4);
		list.insert(2);
		
		list.remove();
	
		list.display();
		System.out.println(list.size());

	}

}

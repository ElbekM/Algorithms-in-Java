package Algorithms.DataStructures.LinkedList;

/**
 * 
 * @author Elbek M
 *
 */
//TODO add exeptions and unit tests
public class SinglyLinkedList {

	private Link first;
	private int size;
	
	public void addHead(int element) {
		Link newLink = new Link(element);
		newLink.setNext(first);
		first = newLink;
		size++;
	}
	
	public void insert(int element, int index) {
		if (index == 0) {
			addHead(element);
		} else {
			Link current = first;
			for (int i = 0; i < index - 1; ++i) {
				current = current.getNext();
			}
			Link newLink = new Link(element);
			newLink.setNext(current.getNext());
			current.setNext(newLink);
			size++;
		}
	}
	
	public int deleteHead() {
		int element = first.getValue();
		first = first.getNext();
		size--;
		return element;
	}
	
	public int delete(int index) {
		if (index == 0) {
			return deleteHead();
		} else {
			Link current = first;
			for (int i = 0; i < index - 1; ++i) {
				current = current.getNext();
			}
			Link deleteLink = current.getNext();
			current.setNext(deleteLink.getNext());
			size--;
			return deleteLink.getValue();
		}
	}
	
	public int get(int index) {
		Link current = first;
		for (int i = 0; i < index; ++i) {
			current = current.getNext();
		}
		return current.getValue();
	}
	
	public Link find(int element) {
		Link current = first;
		while (current != null) {
			if (current.getValue() == element) {
				return current;
			}
			current = current.getNext();
		}
		return null;
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
		
		SinglyLinkedList list = new SinglyLinkedList();
		list.addHead(5);
		list.addHead(3);
		list.addHead(8);
		list.addHead(4);
		
		list.insert(9, 0);
	
		list.display();
		System.out.println(list.get(list.size() - 1));
		list.clear();
		System.out.println(list.size());
	}
}

package Algorithms.DataStructures.Queue;

import Algorithms.DataStructures.LinkedList.SinglyLinkedList;

/**
 * 
 * @author Elbek M
 *
 */

public class QueueList {
	
	private SinglyLinkedList list;
	
	public QueueList() {
		list = new SinglyLinkedList();
	}
	
	public void insert(int element) {
		list.insert(element, list.size());
	}
	
	public int remove() {
		return list.deleteHead();
	}
	
	public int peek() {
		return 0;
	}
	
	public boolean isEmpty() {
		return list.size() == 0;
	}
	
	public void display() {
		list.display();
	}
	

	public static void main(String[] args) {
		
		QueueList queue = new QueueList();
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);

		queue.remove();

		queue.insert(7);
		queue.insert(8);
		queue.insert(8);
		
		queue.display();

	}

}

package Algorithms.DataStructures.Queue;

import Algorithms.DataStructures.LinkedList.SinglyLinkedList;

/**
 * Queue (List-based implementation)
 *
 * A Queue is a linear data structure, or more abstractly a sequential
 * collection. The entities in the collection are kept in order and the
 * principal (or only) operations on the collection are the addition of
 * entities to the rear terminal position, known as enqueue, and removal of
 * entities from the front terminal position, known as dequeue. This makes the
 * queue a First-In-First-Out (FIFO) data structure. In a FIFO data structure,
 * the first element added to the queue will be the first one to be removed.
 *
 * Complexity: add O(1), remove O(1), peek O(1)
 */

public class QueueList {
	
	private SinglyLinkedList list;
	
	public QueueList() {
		list = new SinglyLinkedList();
	}
	
	public void add(int element) {
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
		queue.add(1);
		queue.add(2);
		queue.add(3);

		queue.remove();

		queue.add(7);
		queue.add(8);
		queue.add(8);
		
		queue.display();

	}

}

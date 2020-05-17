package Algorithms.DataStructures.Queue;

import Algorithms.DataStructures.LinkedList.SortedLinkedList;

/**
 * Priority Queue (List-based implementation)
 *
 *
 *
 * @author Elbek M
 *
 */

public class PriorityListQueue {

	private SortedLinkedList list;
	
	public PriorityListQueue() {
		list = new SortedLinkedList();
	}
	
	public void insert(int element) {
		list.insert(element);
	}
	
	public int remove() {
		return list.remove().getValue();
	}
	
	public int size() {
		return list.size();
	}
	
	public void print() {
		list.display();
	}

	// Driver program
	public static void main(String[] args) {
		
		PriorityListQueue queue = new PriorityListQueue();
		queue.insert(5);
		queue.insert(1);
		queue.insert(3);
		queue.insert(4);
		queue.insert(6);

		System.out.println(queue.remove());

		queue.print();

		System.out.println("Size " + queue.size());
	}
}

package Algorithms.DataStructures.Queue;

/**
 * Queue (Array-based implementation)
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

public class QueueArray {

	private int maxSize;
	private int front;
	private int rear;
	private int nElements;
	private int[] queueArray;
	
	public QueueArray(int maxSize) {
		this.maxSize = maxSize;
		queueArray = new int[maxSize];
		rear = -1;
		front = 0;
	}
	
	public void add(int element) {
		if (isFull()) {
			System.out.println("Queue overflow!");
		} else {
			if (rear == maxSize - 1) rear = -1;
			queueArray[++rear] = element;
			nElements++;
		}
	}
	
	public int remove() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		} else {
			if (front == maxSize) front = 0;
			int value = queueArray[front++];
			nElements--;
			return value;
		}
	}
	
	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		} else {
			return queueArray[front];
		}
	}
	
	public boolean isEmpty() {
		return (nElements == 0);
	}
	
	public boolean isFull() {
		return (nElements == maxSize);
	}
	
	public int size() {
		return nElements;
	}
	
	public void print() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
		} else {
			while (!isEmpty()) {
				int value = remove();
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}
	
	
	//Driver program
	public static void main(String[] args) {
		QueueArray queue = new QueueArray(5);
		queue.add(1);
		queue.add(2);
		queue.add(3);

		queue.remove();

		queue.add(7);
		queue.add(8);
		queue.add(8);
		
		queue.print();
			
		System.out.println("is empty " + queue.isEmpty());
		System.out.println("is full  " + queue.isFull());
		System.out.println("Size " + queue.size());
	}
}

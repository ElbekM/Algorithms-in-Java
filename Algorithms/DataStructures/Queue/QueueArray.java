package Algorithms.DataStructures.Queue;

/**
 * 
 * @author Elbek M
 *
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
	
	public void insert(int element) {
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
		queue.insert(1);
		queue.insert(2);
		queue.insert(3);

		queue.remove();

		queue.insert(7);
		queue.insert(8);
		queue.insert(8);
		
		queue.print();
			
		System.out.println("is empty " + queue.isEmpty());
		System.out.println("is full  " + queue.isFull());
		System.out.println("Size " + queue.size());
	}
}

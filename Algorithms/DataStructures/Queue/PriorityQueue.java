package Algorithms.DataStructures.Queue;

/**
 * 
 * @author Elbek M
 *
 */

public class PriorityQueue {
	
	private int maxSize;
	private int nElement;
	private int[] queueArray;
	
	public PriorityQueue(int maxSize) {
		this.maxSize = maxSize;
		queueArray = new int[maxSize];
		nElement = 0;
	}
	
	public void insert(int element) {
		if (isFull()) {
			System.out.println("Queue overflow!");
		}
		else {
			if (isEmpty()) {
				queueArray[nElement++] = element;
			} else {
				int i = 0;
				for (i = nElement - 1; i >= 0; i--) {
					if (element > queueArray[i]) {
						queueArray[i + 1] = queueArray[i];
					}
					else {
						break;
					}
				}
				queueArray[i + 1] = element;
				nElement++;
			}
		}
	}
	
	public int remove() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		} else {
			return queueArray[--nElement];
		}
	}
	
	public int peek() {
		if (isEmpty()) {
			System.out.println("Queue is empty");
			return -1;
		} else {
			return queueArray[nElement - 1];
		}
	}
	
	public boolean isEmpty() {
		return (nElement == 0);
	}
	
	public boolean isFull() {
		return (nElement == maxSize);
	}
	
	public int size() {
		return nElement;
	}
	
	
	//Driver program
	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue(5);
		queue.insert(5);
		queue.insert(1);
		queue.insert(3);
		queue.insert(4);
		queue.insert(6);
		queue.insert(7);
		queue.insert(8);
		queue.insert(8);
		System.out.println(queue.remove());
			
		while (!queue.isEmpty()) {
			int value = queue.remove();
			System.out.println(value);
		}
		System.out.println("is empty " + queue.isEmpty());
		System.out.println("is full  " + queue.isFull());
		System.out.println(queue.size());
		System.out.println(queue.peek());
	}

}

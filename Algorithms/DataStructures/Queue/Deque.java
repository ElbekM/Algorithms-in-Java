package Algorithms.DataStructures.Queue;

/**
 * 
 * @author Elbek M
 *
 */

public class Deque {

	private int maxSize;
	private int leftSide;
	private int rightSide;
	private int nElements;
	private int[] dequeArray;
	
	public Deque(int maxSize) {
		this.maxSize = maxSize;
		dequeArray = new int[maxSize];
		leftSide = 0;
		rightSide = -1;
		nElements = 0;
	}
	
	public void insertLeft(int element) {
		if (isFull()) {
			throw new UnsupportedOperationException("Deque overflow!");
		} else {
			if (leftSide == 0) {
				leftSide = maxSize;
			}
			dequeArray[--leftSide] = element;
			nElements++;
		}
	}
	
	public void insertRight(int element) {
		if (isFull()) {
			throw new UnsupportedOperationException("Deque overflow!");
		} else {
			if (rightSide == maxSize) { 
				rightSide = -1;
			}
			dequeArray[++rightSide] = element;
			nElements++;
		}
	}

	public int removeLeft() {
		if (isEmpty()) {
			throw new UnsupportedOperationException("Deque is empty");
		} else {
			if (leftSide == maxSize) {
				leftSide = 0;
			}
			int value = dequeArray[leftSide++];
			nElements--;
			return value;
		}
	}
	
	public int removeRight() {
		if (isEmpty()) {
			throw new UnsupportedOperationException("Deque is empty");
		} else {
			if (rightSide == -1) {
				rightSide = maxSize - 1;
			}
			int value = dequeArray[rightSide--];
			nElements--;
			return value;
		}
	}
	
	public int peek() {
		if (isEmpty()) {
			throw new UnsupportedOperationException("Deque is empty");
		} else {
			return dequeArray[leftSide];
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
			throw new UnsupportedOperationException("Deque is empty");
		} else {
			while (!isEmpty()) {
				int value = removeLeft();
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}
	
	
	//Driver program
	public static void main(String[] args) {
		Deque deque = new Deque(5);
			
		deque.insertRight(1);
		deque.insertRight(2);
		deque.insertRight(3);
		deque.removeLeft();
		deque.insertLeft(5);
		deque.insertLeft(6);
			
		deque.print();

		System.out.println("is empty " + deque.isEmpty());
		System.out.println("is full  " + deque.isFull());
		System.out.println("Size " + deque.size());
	}
}

package Algorithms.DataStructures.LinkedList;

/**
 * 
 * @author Elbek M
 *
 */
//TODO add exeptions and unit tests
public class DoublyLinkedList {
	
	private Link first;
	private Link last;
	private int size;
	
	public void add(int element) {
		Link newlink = new Link(element);
		if (isEmpty()) {
			first = newlink;
		} else {
			last.setNext(newlink);
			newlink.setPrevious(last);
		}
		last = newlink;
		size++;
	}
	
	public int remove() {

		Link temp = last;
		if (first.getNext() == null) {
			first = null;
		} else {
			last.getPrevious().setNext(null);
		}
		last = last.getPrevious();
		size--;
		return temp.getValue();
	}
	
	//TODO fix and optimize
	public void insert(int element, int index) {
		Link newLink = new Link(element);
		Link current = find(index);
		if (index == 0) {
			newLink.setNext(first);
			first.setPrevious(newLink);
			first = newLink;
		}
		else if (current == last.getNext()) {
			last.setNext(newLink);
			newLink.setPrevious(last);
			last = newLink;
		} else {
			newLink.setNext(current);
			newLink.setPrevious(current.getPrevious());
			current.getPrevious().setNext(newLink);
			current.setPrevious(newLink);
		}
		size++;
	}
	//List is not empty
	public int delete(int index) {
		Link current = find(index);
		if (index == 0) {
			first = current.getNext();
		} else {
			current.getPrevious().setNext(current.getNext());
		}
		if (index == size - 1) {
			last = current.getPrevious();
		} else {
			current.getNext().setPrevious(current.getPrevious());
		}
		size--;
		return current.getValue();
	}
	
	public Link deleteElement(int element) {
		Link current = first;
	
		while (current.getValue() != element) {
            if (current != last) {
                current = current.getNext();
            } else {
                throw new RuntimeException("The element to be deleted does not exist!");
            }
        }

		if (current == first) {
			delete(0);
		} else if (current == last) {
			remove();
		} else {
			current.getPrevious().setNext(current.getNext());
			current.getNext().setPrevious(current.getPrevious());
		}
		size--;
		return current;
	}

	public int get(int index) {
		Link current = find(index);
		return current.getValue();
	}
	
	public Link find(int index) {
		Link current = first;
		for (int i = 0; i <= index; ++i) {
			if (i == index) {
				return current;
			}
			current = current.getNext();
		}
		throw new IndexOutOfBoundsException();
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		size = 0;
		first = last = null;
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
	public static void main(String[] args) throws InterruptedException {
			
		DoublyLinkedList list = new DoublyLinkedList();
		list.add(5);
		list.add(3);
		list.add(8);
		list.add(4);

		//list.delete(0);
		
		list.insert(150, 0);
		//list.deleteElement(150);
		list.display();
	}
}

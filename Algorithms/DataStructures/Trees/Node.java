package Algorithms.DataStructures.Trees;

public class Node {
	
	public int value;
	public int height;
	public Node leftNode;
	public Node rightNode;

	Node(int value) {
		this.value = value;
	}
	
	Node(int value, int height) {
		this.value = value;
		this.height = height;
	}

	@Override
	public String toString() {
		return String.format("Node value = %s", value);
	}
}

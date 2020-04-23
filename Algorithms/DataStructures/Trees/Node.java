package Algorithms.DataStructures.Trees;

public class Node {
	public int value;
	public Node leftNode;
	public Node rightNode;
	
	Node(int value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.format("Node value = %s", value);
	}
}

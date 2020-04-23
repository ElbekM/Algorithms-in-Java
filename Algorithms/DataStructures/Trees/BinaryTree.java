package Algorithms.DataStructures.Trees;

/**
 * Binary Tree
 * 
 */

//TODO optimizations
public class BinaryTree {

	private Node root;

	public Node find(int value) {
		Node currentNode = root;
		while (currentNode != null) {
			if (value > currentNode.value) {
				currentNode = currentNode.rightNode;
			} else if (value < currentNode.value) {
				currentNode = currentNode.leftNode;
			} else {
				return currentNode;
			}
		}
		return null;
	}

	public void insert(int value) {
		Node newNode = new Node(value);
		if (root == null)
			root = newNode;
		else {
			Node currentNode = root;
			Node parent;
			while (currentNode.value != newNode.value) {
				parent = currentNode;
				if (value > currentNode.value) {
					currentNode = currentNode.rightNode;
					if (currentNode == null) {
						parent.rightNode = newNode;
						return;
					}
				} else {
					currentNode = currentNode.leftNode;
					if (currentNode == null) {
						parent.leftNode = newNode;
						return;
					}
				}
			}
		}
	}

	public Node delete(int value) {
		Node currentNode = root;
		Node parent = root;
		// find delete value in tree
		while (currentNode.value != value) {
			parent = currentNode;
			if (value < currentNode.value) {
				currentNode = currentNode.leftNode;
			} else {
				currentNode = currentNode.rightNode;
			}
			if (currentNode == null) {
				return null;
			}
		}
		// delete node without successers
		if (currentNode.leftNode == null && currentNode.rightNode == null) {
			if (currentNode == root) {
				root = null;
			} else if (parent.leftNode == currentNode) {
				parent.leftNode = null;
			} else {
				parent.rightNode = null;
			}
			
		} 
		// delete node with 1 successer
		else if (currentNode.rightNode == null) {
			if (currentNode == root) {
				root = currentNode.leftNode;
			} else if (parent.leftNode == currentNode) {
				parent.leftNode = currentNode.leftNode;
			} else {
				parent.rightNode = currentNode.leftNode;
			}
		} else if (currentNode.leftNode == null) {
			if (currentNode == root) {
				root = currentNode.rightNode;
			} else if (parent.leftNode == currentNode) {
				parent.leftNode = currentNode.rightNode;
			} else {
				parent.rightNode = currentNode.rightNode;
			}
		} 
		// delete node with successers
		else {
			Node successor = getSuccessor(currentNode);
			if (currentNode == root) {
				root = successor;
			} else if (parent.leftNode == currentNode) {
				parent.leftNode = successor;
			} else {
				parent.rightNode = successor;
			}
			successor.leftNode = currentNode.leftNode;
		}

		return currentNode;
	}

	public void display() {
		preOrderTraversal(root);
	}

	private Node getSuccessor(Node delNode) {
		Node successor = delNode;
		Node successorParent = delNode;
		Node currentNode = delNode.rightNode;
		
		while (currentNode != null) {
			successorParent = successor;
			successor = currentNode;
			currentNode = currentNode.leftNode;
		}
		
		if (successor != delNode.rightNode) {
			successorParent.leftNode = successor.rightNode;
			successor.rightNode = delNode.rightNode;
		}
		
		return successor;
	}

	private void preOrderTraversal(Node localRoot) {
		if (localRoot != null) {
			System.out.println(localRoot);
			preOrderTraversal(localRoot.leftNode);
			preOrderTraversal(localRoot.rightNode);
		}
	}

	// Driver Programm
	public static void main(String[] args) {

		BinaryTree binaryTree = new BinaryTree();

		binaryTree.insert(5);
		binaryTree.insert(2);
		binaryTree.insert(1);
		binaryTree.insert(3);
		binaryTree.insert(10);
		binaryTree.insert(20);
		binaryTree.insert(30);
		binaryTree.insert(11);
		binaryTree.insert(29);
		binaryTree.insert(35);
		binaryTree.insert(25);
		binaryTree.insert(26);

		binaryTree.delete(20);

		binaryTree.display();
	}

}

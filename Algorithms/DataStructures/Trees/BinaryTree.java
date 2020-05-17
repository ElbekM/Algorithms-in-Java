package Algorithms.DataStructures.Trees;

/**
 * Binary Search Tree
 *
 * The Binary Search Tree is an ordered table of numbers. Does not permit
 * duplicate keys. This implementation is for an unbalanced BST.
 *
 * Complexity: find O(log N), put O(log N), delete O(log N)
 */

public class BinaryTree {

    private Node root;

    public Node find(int key) {
        Node currentNode = root;
        while (currentNode != null) {
            if (key > currentNode.value) {
                currentNode = currentNode.rightNode;
            } else if (key < currentNode.value) {
                currentNode = currentNode.leftNode;
            } else {
                return currentNode;
            }
        }
        return null;
    }

    public void put(int value) {
        Node newNode = new Node(value);
        if (root == null)
            root = newNode;
        else {
            Node currentNode = root;
            while (currentNode.value != newNode.value) {
                if (value > currentNode.value) {
                    if (currentNode.rightNode == null) {
                        currentNode.rightNode = newNode;
                        return;
                    }
                    currentNode = currentNode.rightNode;
                } else {
                    if (currentNode.leftNode == null) {
                        currentNode.leftNode = newNode;
                        return;
                    }
                    currentNode = currentNode.leftNode;
                }
            }
        }
    }

    public boolean delete(int value) {
        Node currentNode = root;
        Node parent = root;
        // Find delete value in tree
        while (currentNode.value != value) {
            parent = currentNode;
            if (value < currentNode.value) {
                currentNode = currentNode.leftNode;
            } else {
                currentNode = currentNode.rightNode;
            }
            if (currentNode == null) {
                return false;
            }
        }
        // Delete node without successors
        if (currentNode.leftNode == null && currentNode.rightNode == null) {
            redirectNode(currentNode, null, parent);
        }
        // Delete node with 1 successor
        else if (currentNode.rightNode == null) {
            redirectNode(currentNode, currentNode.leftNode, parent);
        } else if (currentNode.leftNode == null) {
            redirectNode(currentNode, currentNode.rightNode, parent);
        }
        // Delete node with successors
        else {
            Node successor = getSuccessor(currentNode);
            redirectNode(currentNode, successor, parent);
            successor.leftNode = currentNode.leftNode;
        }
        return true;
    }

    public void display() {
        preOrderTraversal(root, " -- root");
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

    private void redirectNode(Node currentNode, Node newNode, Node parent) {
        if (currentNode == root) {
            root = newNode;
        } else if (parent.leftNode == currentNode) {
            parent.leftNode = newNode;
        } else {
            parent.rightNode = newNode;
        }
    }

    private void preOrderTraversal(Node localRoot, String side) {
        if (localRoot != null) {
            System.out.println(localRoot + " " + side);
            preOrderTraversal(localRoot.leftNode, " -- left");
            preOrderTraversal(localRoot.rightNode, " -- right");
        }
    }

    // Driver Program
    public static void main(String[] args) {

        BinaryTree binaryTree = new BinaryTree();

        binaryTree.put(5);
        binaryTree.put(2);
        binaryTree.put(1);
        binaryTree.put(3);
        binaryTree.put(10);
        binaryTree.put(20);
        binaryTree.put(30);
        binaryTree.put(11);
        binaryTree.put(29);
        binaryTree.put(35);
        binaryTree.put(25);
        binaryTree.put(26);

        binaryTree.delete(20);

        binaryTree.display();
    }
}

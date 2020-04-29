package Algorithms.DataStructures.Trees;

/**
 * AVL Binary Search Tree
 *
 * The AVL Binary Search Tree is an auto-balanced ordered table of numbers.
 * Does not permit duplicate keys.
 *
 * Complexity: find O(log N), put O(log N), delete O(log N)
 */

public class AVLTree {

    private Node root;

    public void put(int value) {
        root = putNode(root, value);
    }

    public void delete(int value) {
        root = deleteNode(root, value);
    }

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

    public void display() {
        preOrderTraversal(root, " -- root");
    }

    private Node putNode(Node node, int value) {
        if (node == null) {
            return new Node(value);
        } else if (value > node.value) {
            node.rightNode = putNode(node.rightNode, value);
        } else {
            node.leftNode = putNode(node.leftNode, value);
        }
        return rebalance(node);
    }

    private Node deleteNode(Node node, int value) {
        if (node == null) {
            return node;
        } else if (node.value > value) {
            node.leftNode = deleteNode(node.leftNode, value);
        } else if (node.value < value) {
            node.rightNode = deleteNode(node.rightNode, value);
        } else {
            if (node.leftNode == null || node.rightNode == null) {
                node = (node.leftNode == null) ? node.rightNode : node.leftNode;
            } else {
                Node mostLeftChild = mostLeftChild(node.rightNode);
                node.value = mostLeftChild.value;
                node.rightNode = deleteNode(node.rightNode, node.value);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }

    private Node mostLeftChild(Node node) {
        Node currentNode = node;
        while (currentNode.leftNode != null) {
            currentNode = currentNode.leftNode;
        }
        return currentNode;
    }

    private Node rebalance(Node node) {
        correctHeight(node);
        int balance = getBalance(node);
        if (balance > 1) {
            if (getHeight(node.rightNode.rightNode) > getHeight(node.rightNode.leftNode)) {
                node = rotateLeft(node);
            } else {
                node.rightNode = rotateRight(node.rightNode);
                node = rotateLeft(node);
            }
        } else if (balance < -1) {
            if (getHeight(node.leftNode.leftNode) > getHeight(node.leftNode.rightNode)) {
                node = rotateRight(node);
            } else {
                node.leftNode = rotateLeft(node.leftNode);
                node = rotateRight(node);
            }
        }
        return node;
    }

    private Node rotateLeft(Node node) {
        Node childrenNode = node.rightNode;
        node.rightNode = childrenNode.leftNode;
        childrenNode.leftNode = node;
        correctHeight(node);
        correctHeight(childrenNode);
        return childrenNode;
    }

    private Node rotateRight(Node node) {
        Node childrenNode = node.leftNode;
        node.leftNode = childrenNode.rightNode;
        childrenNode.rightNode = node;
        correctHeight(node);
        correctHeight(childrenNode);
        return childrenNode;
    }

    private int getBalance(Node n) {
        return (n == null) ? 0 : getHeight(n.rightNode) - getHeight(n.leftNode);
    }

    private int getHeight(Node n) {
        return n == null ? -1 : n.height;
    }

    private void correctHeight(Node n) {
        n.height = Math.max(getHeight(n.leftNode), getHeight(n.rightNode)) + 1;
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

        AVLTree avlTree = new AVLTree();

        avlTree.put(50);
        avlTree.put(60);
        avlTree.put(40);
        avlTree.put(45);
        avlTree.put(30);
        avlTree.put(47);
        avlTree.put(43);

        avlTree.delete(50);

        avlTree.display();
    }
}

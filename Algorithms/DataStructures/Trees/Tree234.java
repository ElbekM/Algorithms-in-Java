package Algorithms.DataStructures.Trees;

import javax.xml.crypto.Data;

/**
 * Tree 2-3-4
 *
 * Complexity: find O(), put O(), delete O()
 */

public class Tree234 {

    private class DataItem {
        int data;

        DataItem(int data) {
            this.data = data;
        }
    }

    private class Node {

        static final int ORDER = 4;
        int numItems;
        Node parent;
        Node[] childArray = new Node[ORDER];
        DataItem[] itemArray = new DataItem[ORDER - 1];

        void connectChild(int childNum, Node child) {
            childArray[childNum] = child;
            if (child != null) {
                child.parent = this;
            }
        }

        Node disconnectChild(int childNum) {
            Node tempNode = childArray[childNum];
            childArray[childNum] = null;
            return tempNode;
        }

        Node getChild(int childNum) {
            return childArray[childNum];
        }

        Node getParent() {
            return parent;
        }

        boolean isLeaf() {
            return childArray[0] == null;
        }

        int getNumData() {
            return numItems;
        }

        DataItem getItem(int index) {
            return itemArray[index];
        }

        boolean isFull() {
            return numItems == ORDER - 1;
        }

        int findItem(int key) {
            for (int i = 0; i < ORDER - 1; ++i) {
                if (itemArray[i] == null) {
                    break;
                } else if (itemArray[i].data == key) {
                    return i;
                }
            }
            return -1;
        }

        int insertItem(DataItem newItem) {
            numItems++;
            int newKey = newItem.data;

            for (int i = ORDER - 2; i >= 0; --i) {
                if (itemArray[i] == null) {
                    continue;
                } else {
                    int thisKey = itemArray[i].data;
                    if (newKey < thisKey) {
                        itemArray[i + 1] = itemArray[i];
                    } else {
                        itemArray[i + 1] = newItem;
                        return i + 1;
                    }
                }
            }
            itemArray[0] = newItem;
            return 0;
        }

        DataItem removeItem() {
            DataItem temp = itemArray[numItems - 1];
            itemArray[numItems - 1] = null;
            numItems--;
            return temp;
        }
    }

    private Node root;

    public int find(int key) {

        return 0;
    }

    public void insert(int key) {

    }

    public void split(Node thisNode) {

    }

    public Node getNextChild(Node theNode,int key) {
        return null;
    }

}

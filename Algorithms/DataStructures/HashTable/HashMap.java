package Algorithms.DataStructures.HashTable;

/**
 * HashMap
 *
 * A Hash Map is a data structure that implements the interface of an
 * associative array, it allows you to store pairs (key, value)
 *
 * Collision resolution: double hash
 *
 * Complexity: find O(1), put O(1), delete O(1)
 */

public class HashMap<K, V> {

    private DataItem<K, V>[] hashArray;
    private int arraySize;

    public HashMap(int size) {
        hashArray = new DataItem[size];
        arraySize = size;
    }

    public void put(K key, V value) {
        int hashIndex = hashFunc(key);
        int stepSize = hashFuncSecondary(key);

        while (hashArray[hashIndex] != null) {
            hashIndex += stepSize;
            hashIndex %= arraySize;
        }
        hashArray[hashIndex] = new DataItem<K, V>(key, value);
    }

    public V delete(K key) {
        int hashIndex = hashFunc(key);
        int stepSize = hashFuncSecondary(key);

        while (hashArray[hashIndex] != null) {
            DataItem<K, V> deletedItem = hashArray[hashIndex];
            if (deletedItem.key == key) {
                hashArray[hashIndex] = null;
                return deletedItem.value;
            }
            hashIndex += stepSize;
            hashIndex %= arraySize;
        }
        return null;
    }

    public V find(K key) {
        int hashIndex = hashFunc(key);
        int stepSize = hashFuncSecondary(key);

        while (hashArray[hashIndex] != null) {
            DataItem<K, V> findItem = hashArray[hashIndex];
            if (findItem.key == key) {
                return findItem.value;
            }
            hashIndex += stepSize;
            hashIndex %= arraySize;
        }
        return null;
    }

    public int hashFunc(K key) {
        return (int)key % arraySize;
    }

    public int hashFuncSecondary(K key) {
        return 5 - (int)key % 5;
    }

    public void displayTable() {
        System.out.println("HashTable: ");
        for (int i = 0; i < arraySize; ++i) {
            DataItem di = hashArray[i];
            if (di != null)
                System.out.print(di.key + " ");
            else
                System.out.print("** ");
        }
        System.out.println("");
    }

    private static class DataItem<K, V> {

        private final K key;
        private V value;

        public DataItem(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    // Driver program
    public static void main(String[] args) {

        HashMap<Integer, String> hashMap = new HashMap<>(9);

        hashMap.put(5, "apple");
        hashMap.put(7, "banana");
        hashMap.put(6, "juice");
        hashMap.put(14, "pineapple");
        hashMap.put(23, "strawberry");
        hashMap.delete(6);

        hashMap.displayTable();
    }
}

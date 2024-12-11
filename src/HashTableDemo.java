class MyMapNode<K, V> {
    K key;
    V value;
    MyMapNode<K, V> next;

    public MyMapNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class HashTable<K, V> {
    private MyMapNode<K, V>[] buckets;
    private int capacity;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new MyMapNode[capacity];
    }

    private int getBucketIndex(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        MyMapNode<K, V> head = buckets[index];

        // Check if key already exists, update value
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Key not found, add a new node
        head = buckets[index];
        MyMapNode<K, V> newNode = new MyMapNode<>(key, value);
        newNode.next = head;
        buckets[index] = newNode;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        MyMapNode<K, V> head = buckets[index];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null; // Key not found
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        MyMapNode<K, V> head = buckets[index];
        MyMapNode<K, V> prev = null;

        while (head != null) {
            if (head.key.equals(key)) {
                if (prev == null) {
                    buckets[index] = head.next;
                } else {
                    prev.next = head.next;
                }
                return;
            }
            prev = head;
            head = head.next;
        }
    }

    public void printHashTable() {
        for (int i = 0; i < capacity; i++) {
            MyMapNode<K, V> head = buckets[i];
            if (head != null) {
                System.out.print("Bucket " + i + ": ");
                while (head != null) {
                    System.out.print("(" + head.key + ", " + head.value + ") -> ");
                    head = head.next;
                }
                System.out.println("null");
            }
        }
    }
}

public class HashTableDemo {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>(10);

        // Example 1: Word frequency in a sentence
        String sentence = "To be or not to be";
        String[] words = sentence.toLowerCase().split(" ");
        for (String word : words) {
            Integer count = hashTable.get(word);
            if (count == null) {
                count = 0;
            }
            hashTable.put(word, count + 1);
        }

        System.out.println("Word frequencies in sentence:");
        for (String word : words) {
            System.out.println(word + ": " + hashTable.get(word));
        }

        // Example 2: Word frequency in a paragraph
        String paragraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        words = paragraph.toLowerCase().split(" ");
        for (String word : words) {
            Integer count = hashTable.get(word);
            if (count == null) {
                count = 0;
            }
            hashTable.put(word, count + 1);
        }

        System.out.println("\nWord frequencies in paragraph:");
        hashTable.printHashTable();

        // Example 3: Remove the word "avoidable"
        System.out.println("\nRemoving the word 'avoidable':");
        hashTable.remove("avoidable");
        hashTable.printHashTable();
    }
}

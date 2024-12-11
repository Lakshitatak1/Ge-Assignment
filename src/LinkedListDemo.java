class Node<T extends Comparable<T>> {
    T data;
    Node<T> next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList<T extends Comparable<T>> {
    private Node<T> head;

    // Add at the beginning
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    // Append at the end
    public void append(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Insert after a specific node
    public void insertAfter(T key, T data) {
        Node<T> temp = head;
        while (temp != null && !temp.data.equals(key)) {
            temp = temp.next;
        }
        if (temp != null) {
            Node<T> newNode = new Node<>(data);
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    // Delete the first node
    public void pop() {
        if (head != null) {
            head = head.next;
        }
    }

    // Delete the last node
    public void popLast() {
        if (head == null || head.next == null) {
            head = null;
            return;
        }
        Node<T> temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Search for a node
    public boolean search(T key) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(key)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Delete a specific node
    public void delete(T key) {
        if (head == null) return;
        if (head.data.equals(key)) {
            head = head.next;
            return;
        }
        Node<T> temp = head;
        while (temp.next != null && !temp.next.data.equals(key)) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }

    // Get the size of the linked list
    public int size() {
        int count = 0;
        Node<T> temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    // Add in sorted order
    public void addSorted(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null || head.data.compareTo(data) > 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node<T> temp = head;
        while (temp.next != null && temp.next.data.compareTo(data) < 0) {
            temp = temp.next;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Print the linked list
    public void printList() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        // Creating LinkedList: 56->30->70
        list.addFirst(70);
        list.addFirst(30);
        list.addFirst(56);
        System.out.println("LinkedList after adding elements: ");
        list.printList();

        // Deleting the first element
        list.pop();
        System.out.println("After deleting the first element: ");
        list.printList();

        // Deleting the last element
        list.popLast();
        System.out.println("After deleting the last element: ");
        list.printList();

        // Searching for an element
        System.out.println("Searching for 30: " + list.search(30));

        // Inserting 40 after 30
        list.insertAfter(30, 40);
        System.out.println("After inserting 40 after 30: ");
        list.printList();

        // Deleting 40
        list.delete(40);
        System.out.println("After deleting 40: ");
        list.printList();

        list.addSorted(70);
        list.addSorted(30);
        list.addSorted(40);
        list.addSorted(56);
        System.out.println("LinkedList in sorted order: ");
        list.printList();

        System.out.println("Size of the LinkedList: " + list.size());
    }
}

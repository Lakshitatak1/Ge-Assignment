class Node2<T> {
    T data;
    Node2<T> next;

    Node2(T data) {
        this.data = data;
        this.next = null;
    }
}

class Queue<T> {
    private Node2<T> front;
    private Node2<T> rear;

    public Queue() {
        front = rear = null;
    }

    // Enqueue: Add an element to the end of the queue
    public void enqueue(T data) {
        Node2<T> newNode = new Node2<>(data);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Dequeue: Remove an element from the front of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T data = front.data;
        front = front.next;
        if (front == null) { // If the queue becomes empty
            rear = null;
        }
        return data;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Print the queue elements
    public void printQueue() {
        Node2<T> temp = front;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class QueueDemo {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();

        // Enqueue elements: 56->30->70
        queue.enqueue(56);
        queue.enqueue(30);
        queue.enqueue(70);

        System.out.println("Queue after enqueue operations: ");
        queue.printQueue();

        // Dequeue elements one by one
        System.out.println("Dequeuing elements:");
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }

        // Attempt to dequeue from an empty queue (will throw an exception)
        try {
            queue.dequeue();
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

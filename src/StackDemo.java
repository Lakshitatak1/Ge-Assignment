class Node1<T> {
    T data;
    Node1<T> next;

    Node1(T data) {
        this.data = data;
        this.next = null;
    }
}

class Stack<T> {
    private Node1<T> top;

    public Stack() {
        top = null;
    }

    // Push an element onto the stack
    public void push(T data) {
        Node1<T> newNode = new Node1<>(data);
        newNode.next = top;
        top = newNode;
    }

    // Peek the top element of the stack
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    // Pop an element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    // Print the stack elements
    public void printStack() {
        Node1<T> temp = top;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }
}

public class StackDemo {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack: 70->30->56
        stack.push(70);
        stack.push(30);
        stack.push(56);

        System.out.println("Stack after push operations: ");
        stack.printStack();

        // Peek the top element
        System.out.println("Peek top element: " + stack.peek());

        // Pop elements until the stack is empty
        System.out.println("Popping elements from stack:");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        // Attempt to pop from an empty stack (will throw an exception)
        try {
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}

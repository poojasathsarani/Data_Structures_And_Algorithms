public class LinkedListStack<T> {
    private Node<T> top;
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedListStack() {
        top = null;
        size = 0;
    }

    // Method to add an element to the top of the stack
    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        newNode.next = top;
        top = newNode;
        size++;
    }

    // Method to remove and return the top element of the stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        size--;
        return data;
    }

    // Method to view the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the stack
    public int size() {
        return size;
    }

    // Method to display the elements of the stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        Node<T> current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Stack after pushing elements:");
        stack.display(); // Output: 3 2 1

        System.out.println("Top element is: " + stack.peek()); // Output: 3

        System.out.println("Popped element is: " + stack.pop()); // Output: 3
        System.out.println("Stack after popping an element:");
        stack.display(); // Output: 2 1

        System.out.println("Stack size is: " + stack.size()); // Output: 2
    }
}

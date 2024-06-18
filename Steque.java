public class Steque<T> {
    private Node<T> front;
    private Node<T> rear;
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Steque() {
        front = null;
        rear = null;
        size = 0;
    }

    // Push method to add an element to the front
    public void push(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front = newNode;
        }
        size++;
    }

    // Enqueue method to add an element to the back
    public void enqueue(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Pop method to remove an element from the front
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Steque is empty");
        }
        T data = front.data;
        front = front.next;
        size--;
        if (isEmpty()) {
            rear = null;
        }
        return data;
    }

    // Peek method to view the front element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Steque is empty");
        }
        return front.data;
    }

    // Method to check if the steque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the steque
    public int size() {
        return size;
    }

    // Main method for testing
    public static void main(String[] args) {
        Steque<Integer> steque = new Steque<>();

        steque.push(1);
        steque.push(2);
        steque.push(3);

        System.out.println("Front element is: " + steque.peek()); // 3
        System.out.println("Steque size is: " + steque.size()); // 3

        System.out.println("Popped element is: " + steque.pop()); // 3
        System.out.println("Front element is: " + steque.peek()); // 2

        steque.enqueue(4);
        System.out.println("Front element is: " + steque.peek()); // 2
        System.out.println("Steque size is: " + steque.size()); // 3

        System.out.println("Popped element is: " + steque.pop()); // 2
        System.out.println("Front element is: " + steque.peek()); // 1
        System.out.println("Popped element is: " + steque.pop()); // 1
        System.out.println("Popped element is: " + steque.pop()); // 4

        System.out.println("Is steque empty? " + steque.isEmpty()); // true
    }
}

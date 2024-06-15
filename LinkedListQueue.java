public class LinkedListQueue {
    private Node front; // Points to the front of the queue
    private Node rear;  // Points to the rear of the queue

    // Nested Node class
    private static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedListQueue() {
        this.front = null;
        this.rear = null;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return front == null;
    }

    // Method to add an element to the rear of the queue
    public void enqueue(int data) {
        Node newNode = new Node(data);

        // If queue is empty, new node is both front and rear
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            // Otherwise, add the new node at the end and update rear
            rear.next = newNode;
            rear = newNode;
        }
    }

    // Method to remove an element from the front of the queue
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow");
        }

        // Retrieve the data from the front node
        int data = front.data;

        // Move front pointer to the next node
        front = front.next;

        // If queue is now empty, also set rear to null
        if (front == null) {
            rear = null;
        }

        return data;
    }

    // Method to peek at the front element of the queue
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue Underflow");
        }
        return front.data;
    }

    // Method to display the queue
    public void display() {
        Node current = front;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedListQueue queue = new LinkedListQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Queue elements:");
        queue.display(); // Output: 10 20 30

        System.out.println("Dequeued element: " + queue.dequeue()); // Output: Dequeued element: 10

        System.out.println("Queue elements after dequeue:");
        queue.display(); // Output: 20 30

        System.out.println("Peek element: " + queue.peek()); // Output: Peek element: 20
    }
}

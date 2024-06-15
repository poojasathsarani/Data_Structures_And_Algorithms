public class ArrayQueue<T> {
    private T[] queue;
    private int front;
    private int rear;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor
    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        queue = (T[]) new Object[DEFAULT_CAPACITY];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue method to add an element to the queue
    public void enqueue(T element) {
        if (size == queue.length) {
            resize(2 * queue.length); // Double the array size if full
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = element;
        size++;
    }

    // Dequeue method to remove and return the front element of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T element = queue[front];
        queue[front] = null; // Avoid loitering
        front = (front + 1) % queue.length;
        size--;
        if (size > 0 && size == queue.length / 4) {
            resize(queue.length / 2); // Shrink the array size if it's a quarter full
        }
        return element;
    }

    // Peek method to view the front element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return queue[front];
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the queue
    public int size() {
        return size;
    }

    // Method to resize the array when needed
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] newArray = (T[]) new Object[capacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = queue[(front + i) % queue.length];
        }
        queue = newArray;
        front = 0;
        rear = size - 1;
    }

    // Main method for testing
    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Front element is: " + queue.peek()); // Output: Front element is: 1
        System.out.println("Queue size is: " + queue.size());    // Output: Queue size is: 3

        System.out.println("Dequeued element is: " + queue.dequeue()); // Output: Dequeued element is: 1
        System.out.println("Front element is: " + queue.peek());       // Output: Front element is: 2

        System.out.println("Queue size is: " + queue.size()); // Output: Queue size is: 2
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? false

        queue.enqueue(4);
        System.out.println("Front element is: " + queue.peek()); // Output: Front element is: 2
        System.out.println("Queue size is: " + queue.size()); // Output: Queue size is: 3
    }
}

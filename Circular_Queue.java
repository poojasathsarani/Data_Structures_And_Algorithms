public class Circular_Queue {
    private int[] data;
    private int head;
    private int tail;
    private int size;

    public Circular_Queue(int k) {
        data = new int[k];
        head = -1;
        tail = -1;
        size = k;
    }

    // Insert an element into the circular queue. Return true if the operation is successful.
    public boolean enqueue(int value) {
        if (isFull()) {
            return false;
        }
        if (isEmpty()) {
            head = 0;
        }
        tail = (tail + 1) % size;
        data[tail] = value;
        return true;
    }

    // Delete an element from the circular queue. Return true if the operation is successful.
    public boolean dequeue() {
        if (isEmpty()) {
            return false;
        }
        if (head == tail) {
            head = -1;
            tail = -1;
            return true;
        }
        head = (head + 1) % size;
        return true;
    }

    // Get the front item from the queue.
    public int front() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return data[head];
    }

    // Get the last item from the queue.
    public int rear() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return data[tail];
    }

    // Checks whether the circular queue is empty or not.
    public boolean isEmpty() {
        return head == -1;
    }

    // Checks whether the circular queue is full or not.
    public boolean isFull() {
        return ((tail + 1) % size) == head;
    }

    public static void main(String[] args) {
        Circular_Queue circularQueue = new Circular_Queue(3);
        System.out.println(circularQueue.enqueue(1));  // true
        System.out.println(circularQueue.enqueue(2));  // true
        System.out.println(circularQueue.enqueue(3));  // true
        System.out.println(circularQueue.enqueue(4));  // false, queue is full
        System.out.println(circularQueue.rear());      // 3
        System.out.println(circularQueue.isFull());    // true
        System.out.println(circularQueue.dequeue());   // true
        System.out.println(circularQueue.enqueue(4));  // true
        System.out.println(circularQueue.rear());      // 4
    }
}

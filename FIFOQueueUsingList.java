import java.util.ArrayList;
import java.util.List;

public class FIFOQueueUsingList<T> {
    private List<T> list;

    // Constructor
    public FIFOQueueUsingList() {
        list = new ArrayList<>();
    }

    // Enqueue method to add an element to the queue
    public void enqueue(T element) {
        list.add(element);
    }

    // Dequeue method to remove and return the front element of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.remove(0);
    }

    // Peek method to view the front element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return list.get(0);
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Method to get the size of the queue
    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        FIFOQueueUsingList<Integer> queue = new FIFOQueueUsingList<>();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Front element is: " + queue.peek()); // Output: Front element is: 1
        System.out.println("Queue size is: " + queue.size());    // Output: Queue size is: 3

        System.out.println("Dequeued element is: " + queue.dequeue()); // Output: Dequeued element is: 1
        System.out.println("Front element is: " + queue.peek());       // Output: Front element is: 2

        System.out.println("Queue size is: " + queue.size()); // Output: Queue size is: 2
        System.out.println("Is queue empty? " + queue.isEmpty()); // Output: Is queue empty? false
    }
}

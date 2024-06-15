import java.util.ArrayDeque;
import java.util.Deque;

public class FIFOQueueUsingDeque<T> {
    private Deque<T> deque;

    public FIFOQueueUsingDeque() {
        deque = new ArrayDeque<>();
    }

    public void enqueue(T element) {
        deque.addLast(element);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return deque.removeFirst();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return deque.peekFirst();
    }

    public boolean isEmpty() {
        return deque.isEmpty();
    }

    public int size() {
        return deque.size();
    }

    public static void main(String[] args) {
        FIFOQueueUsingDeque<Integer> queue = new FIFOQueueUsingDeque<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println("Front element is: " + queue.peek()); // 1
        System.out.println("Queue size is: " + queue.size()); // 3

        System.out.println("Dequeued element is: " + queue.dequeue()); // 1
        System.out.println("Front element is: " + queue.peek()); // 2

        System.out.println("Queue size is: " + queue.size()); // 2
        System.out.println("Is queue empty? " + queue.isEmpty()); // false

        queue.enqueue(4);
        System.out.println("Front element is: " + queue.peek()); // 2
        System.out.println("Queue size is: " + queue.size()); // 3
    }
}

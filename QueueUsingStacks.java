import java.util.Stack;

public class QueueUsingStacks<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    // Constructor
    public QueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue method to add an element to the queue
    public void enqueue(T element) {
        stack1.push(element);
    }

    // Dequeue method to remove and return the front element of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        transferStack1ToStack2();
        return stack2.pop();
    }

    // Peek method to view the front element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        transferStack1ToStack2();
        return stack2.peek();
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Method to get the size of the queue
    public int size() {
        return stack1.size() + stack2.size();
    }

    // Helper method to transfer elements from stack1 to stack2
    private void transferStack1ToStack2() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        QueueUsingStacks<Integer> queue = new QueueUsingStacks<>();

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

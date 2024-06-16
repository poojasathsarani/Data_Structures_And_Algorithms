import java.util.Stack;

public class EnqueueFriendlyFIFOQueueUsingStacks<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public EnqueueFriendlyFIFOQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(T element) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(element);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return stack1.pop();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }

    public int size() {
        return stack1.size();
    }

    public static void main(String[] args) {
        EnqueueFriendlyFIFOQueueUsingStacks<Integer> queue = new EnqueueFriendlyFIFOQueueUsingStacks<>();
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

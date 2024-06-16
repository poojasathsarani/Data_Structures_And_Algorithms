import java.util.Stack;

public class DequeueFriendlyFIFOQueueUsingStacks<T> {
    private Stack<T> stack1;
    private Stack<T> stack2;

    public DequeueFriendlyFIFOQueueUsingStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void enqueue(T element) {
        stack1.push(element);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public int size() {
        return stack1.size() + stack2.size();
    }

    public static void main(String[] args) {
        DequeueFriendlyFIFOQueueUsingStacks<Integer> queue = new DequeueFriendlyFIFOQueueUsingStacks<>();
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

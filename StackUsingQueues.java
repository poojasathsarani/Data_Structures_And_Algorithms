import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues<T> {
    private Queue<T> queue1;
    private Queue<T> queue2;

    // Constructor
    public StackUsingQueues() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push element onto the stack
    public void push(T element) {
        queue2.add(element); // Always add to queue2

        // Transfer all elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.add(queue1.remove());
        }

        // Swap the names of the two queues
        Queue<T> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Pop element from the stack
    public T pop() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.remove();
    }

    // Peek the top element of the stack
    public T peek() {
        if (queue1.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return queue1.peek();
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    // Get the size of the stack
    public int size() {
        return queue1.size();
    }

    public static void main(String[] args) {
        StackUsingQueues<Integer> stack = new StackUsingQueues<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element is: " + stack.peek()); // Output: Top element is: 3
        System.out.println("Stack size is: " + stack.size());  // Output: Stack size is: 3

        System.out.println("Popped element is: " + stack.pop()); // Output: Popped element is: 3
        System.out.println("Top element is: " + stack.peek());   // Output: Top element is: 2

        System.out.println("Stack is empty: " + stack.isEmpty()); // Output: Stack is empty: false
    }
}

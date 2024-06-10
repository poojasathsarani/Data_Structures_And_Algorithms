// ArrayStack.java
public class Array_Stack<T> {
    private T[] stack;
    private int top;
    private static final int DEFAULT_CAPACITY = 10;

    // Constructor
    public Array_Stack() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        stack = (T[]) new Object[initialCapacity];
        top = -1;
    }

    // Push method to add element to the stack
    public void push(T value) {
        if (isFull()) {
            resize(2 * stack.length); // double the array size if full
        }
        stack[++top] = value;
    }

    // Pop method to remove element from the stack
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T value = stack[top];
        stack[top--] = null; // Avoid loitering
        if (top > 0 && top == stack.length / 4) {
            resize(stack.length / 2);
        }
        return value;
    }

    // Peek method to view the top element without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[top];
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == stack.length - 1;
    }

    // Method to get the current size of the stack
    public int size() {
        return top + 1;
    }

    // Method to resize the array when needed
    @SuppressWarnings("unchecked")
    private void resize(int capacity) {
        T[] newStack = (T[]) new Object[capacity];
        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }
        stack = newStack;
    }

    // Main method for testing
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println("Top element is: " + stack.peek());
        System.out.println("Stack size is: " + stack.size());

        System.out.println("Popped element is: " + stack.pop());
        System.out.println("Popped element is: " + stack.pop());

        System.out.println("Stack size is: " + stack.size());
        System.out.println("Is stack empty? " + stack.isEmpty());

        stack.push(4);
        System.out.println("Top element is: " + stack.peek());
    }
}

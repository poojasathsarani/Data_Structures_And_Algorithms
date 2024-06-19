public class CircularSinglyLinkedList<T> {
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public CircularSinglyLinkedList() {
        tail = null;
        size = 0;
    }

    // Method to add an element to the front of the list
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
        size++;
    }

    // Method to add an element to the back of the list
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Method to remove and return the first element of the list
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        Node<T> head = tail.next;
        if (head == tail) { // Only one element in the list
            tail = null;
        } else {
            tail.next = head.next;
        }
        size--;
        return head.data;
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the list
    public int size() {
        return size;
    }

    // Method to traverse the list and print the elements
    public void traverse() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node<T> current = tail.next;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != tail.next);
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        CircularSinglyLinkedList<Integer> list = new CircularSinglyLinkedList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        System.out.println("List after adding elements to the front:");
        list.traverse(); // 3 2 1

        list.addLast(4);
        list.addLast(5);
        System.out.println("List after adding elements to the back:");
        list.traverse(); // 3 2 1 4 5

        System.out.println("Removed first element: " + list.removeFirst()); // 3
        System.out.println("List after removing first element:");
        list.traverse(); // 2 1 4 5
    }
}

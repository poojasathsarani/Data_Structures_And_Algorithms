public class CircularDoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    private static class Node<T> {
        private T data;
        private Node<T> next;
        private Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public CircularDoublyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // Method to add an element to the front of the list
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            head = newNode;
        }
        size++;
    }

    // Method to add an element to the back of the list
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = newNode;
            head.next = head;
            head.prev = head;
        } else {
            newNode.next = head;
            newNode.prev = tail;
            tail.next = newNode;
            head.prev = newNode;
            tail = newNode;
        }
        size++;
    }

    // Method to remove and return the first element of the list
    public T removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        T data = head.data;
        if (head == tail) { // Only one element in the list
            head = tail = null;
        } else {
            head = head.next;
            head.prev = tail;
            tail.next = head;
        }
        size--;
        return data;
    }

    // Method to remove and return the last element of the list
    public T removeLast() {
        if (isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        T data = tail.data;
        if (head == tail) { // Only one element in the list
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = head;
            head.prev = tail;
        }
        size--;
        return data;
    }

    // Method to check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Method to get the size of the list
    public int size() {
        return size;
    }

    // Method to traverse the list from head to tail
    public void traverseForward() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node<T> current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    // Method to traverse the list from tail to head
    public void traverseBackward() {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        Node<T> current = tail;
        do {
            System.out.print(current.data + " ");
            current = current.prev;
        } while (current != tail);
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        CircularDoublyLinkedList<Integer> list = new CircularDoublyLinkedList<>();

        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        System.out.println("List after adding elements to the front:");
        list.traverseForward(); // 3 2 1

        list.addLast(4);
        list.addLast(5);
        System.out.println("List after adding elements to the back:");
        list.traverseForward(); // 3 2 1 4 5

        System.out.println("List traversed backward:");
        list.traverseBackward(); // 5 4 1 2 3

        System.out.println("Removed first element: " + list.removeFirst()); // 3
        System.out.println("Removed last element: " + list.removeLast()); // 5
        System.out.println("List after removing elements:");
        list.traverseForward(); // 2 1 4
    }
}

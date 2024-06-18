public class Doubly_Linked_List<T> {
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

    public Doubly_Linked_List() {
        head = null;
        tail = null;
        size = 0;
    }

    // Method to add an element to the front of the list
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Method to add an element to the back of the list
    public void addLast(T element) {
        Node<T> newNode = new Node<>(element);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
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
        head = head.next;
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
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
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
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
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to traverse the list from tail to head
    public void traverseBackward() {
        Node<T> current = tail;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        Doubly_Linked_List<Integer> list = new Doubly_Linked_List<>();

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

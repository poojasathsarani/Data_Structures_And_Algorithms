public class Singly_Linked_List {

    // Node class representing each element in the list
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head; // Head node of the linked list
    private int size; // Size of the linked list

    public Singly_Linked_List() {
        this.head = null;
        this.size = 0;
    }

    // Add a new element at the end of the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Remove an element from the list by value
    public boolean remove(int data) {
        if (head == null) {
            return false;
        }
        if (head.data == data) {
            head = head.next;
            size--;
            return true;
        }
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        if (current.next == null) {
            return false;
        }
        current.next = current.next.next;
        size--;
        return true;
    }

    // Get the size of the linked list
    public int size() {
        return size;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Print all elements in the list
    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Singly_Linked_List list = new Singly_Linked_List();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("List elements after adding 1, 2, 3:");
        list.printList(); // Output: 1 2 3

        System.out.println("Size of the list: " + list.size()); // Output: 3

        list.remove(2);
        System.out.println("List elements after removing 2:");
        list.printList(); // Output: 1 3

        System.out.println("Size of the list: " + list.size()); // Output: 2

        System.out.println("Is list empty? " + list.isEmpty()); // Output: false

        list.remove(1);
        list.remove(3);
        System.out.println("List elements after removing 1 and 3:");
        list.printList(); // Output: (nothing, list is empty)

        System.out.println("Is list empty? " + list.isEmpty()); // Output: true
    }
}

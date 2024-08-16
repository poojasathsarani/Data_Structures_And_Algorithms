import java.util.Arrays;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    // Returns the index of the parent of the node at index i
    private int parent(int i) { return (i - 1) / 2; }

    // Returns the index of the left child of the node at index i
    private int leftChild(int i) { return 2 * i + 1; }

    // Returns the index of the right child of the node at index i
    private int rightChild(int i) { return 2 * i + 2; }

    // Swaps two elements in the heap array
    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Inserts a new element into the heap
    public void insert(int key) {
        if (size == capacity) {
            throw new IllegalStateException("Heap is full");
        }

        size++;
        int i = size - 1;
        heap[i] = key;

        // Fix the max heap property if it's violated
        while (i != 0 && heap[parent(i)] < heap[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Extracts the maximum element (root of the heap)
    public int extractMax() {
        if (size <= 0) {
            throw new IllegalStateException("Heap is empty");
        }
        if (size == 1) {
            size--;
            return heap[0];
        }

        // Store the maximum value, and remove it from the heap
        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        maxHeapify(0);

        return root;
    }

    // Ensures the heap property is maintained
    private void maxHeapify(int i) {
        int largest = i;
        int left = leftChild(i);
        int right = rightChild(i);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    // Returns the maximum element in the heap (the root)
    public int getMax() {
        if (size <= 0) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap[0];
    }

    // Prints the heap array
    public void printHeap() {
        System.out.println("Heap: " + Arrays.toString(Arrays.copyOfRange(heap, 0, size)));
    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);
        
        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(30);
        maxHeap.insert(40);

        maxHeap.printHeap(); // Output: Heap: [40, 30, 15, 10, 20]

        System.out.println("Max value extracted: " + maxHeap.extractMax()); // Output: 40
        maxHeap.printHeap(); // Output: Heap: [30, 20, 15, 10]
        
        System.out.println("Max value: " + maxHeap.getMax()); // Output: 30
    }
}

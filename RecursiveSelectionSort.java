public class RecursiveSelectionSort {

    // Function to perform selection sort recursively
    public static void selectionSort(int[] arr, int n, int index) {
        // Base case: If index has reached the end of the array
        if (index == n) {
            return;
        }

        // Find the minimum element in the unsorted part of the array
        int minIndex = index;
        for (int i = index + 1; i < n; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }

        // Swap the found minimum element with the current element
        int temp = arr[minIndex];
        arr[minIndex] = arr[index];
        arr[index] = temp;

        // Recursively call selection sort for the remaining part of the array
        selectionSort(arr, n, index + 1);
    }

    // Helper function to print the array
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        System.out.println("Unsorted array:");
        printArray(arr);

        selectionSort(arr, arr.length, 0);

        System.out.println("Sorted array:");
        printArray(arr);
    }
}

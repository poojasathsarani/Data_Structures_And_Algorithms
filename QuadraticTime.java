public class QuadraticTime {
    public static void main(String[] args) {
        int[] array = {64, 34, 25, 12, 22, 11, 90};
        int n = array.length;
        
        for (int i = 0; i < n - 1; i++) {       // O(n) loop
            for (int j = 0; j < n - i - 1; j++) { // O(n) loop
                if (array[j] > array[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        System.out.print("Sorted array: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}

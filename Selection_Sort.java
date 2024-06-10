public class Selection_Sort {

    public static void main(String[] args) {

        int[] array = {50, 14, 69, 83, 22};

        System.out.println("Array before sorting:");
        displayArray(array);

        selectionSort(array);

        System.out.println("Array after sorting:");
        displayArray(array);
    }

    public static void selectionSort(int[] array) {
        int length = array.length;

        for (int i = 0; i < length - 1; i++) {
            int smallestIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (array[j] < array[smallestIndex]) {
                    smallestIndex = j;
                }
            }

            int temporary = array[smallestIndex];
            array[smallestIndex] = array[i];
            array[i] = temporary;
        }
    }

    public static void displayArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

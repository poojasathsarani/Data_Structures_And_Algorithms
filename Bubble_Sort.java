public class Bubble_Sort {

  // Method to perform bubble sort on an array
  public static void bubbleSort(int[] array) {
    int numElements = array.length;
    boolean swapped;

    // Traverse through all array elements
    for (int i = 0; i < numElements - 1; i++) {
      swapped = false;

      // Last i elements are already in place
      for (int j = 0; j < numElements - 1 - i; j++) {
        // Swap if the element found is greater than the next element
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
          swapped = true;
        }
      }

      // If no two elements were swapped by inner loop, then break
      if (!swapped) {
        break;
      }
    }
  }

  // Method to print an array
  public static void arrayPrint(int[] array) {
    int numElements = array.length;
    for (int i = 0; i < numElements; i++) {
      System.out.print(array[i] + " ");
    }
    System.out.println();
  }

  // Main method to test the bubble sort algorithm
  public static void main(String[] args) {
    int[] array = {32, 10, 93, 46, 55, 79, 81};

    System.out.println("Unsorted array:");
    arrayPrint(array);

    // Call bubbleSort instead of sortArray
    bubbleSort(array);

    System.out.println("Sorted array:");
    arrayPrint(array);
  }
}

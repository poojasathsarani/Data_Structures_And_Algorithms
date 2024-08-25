public class ConstantTime {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        int index = 2;
        int value = array[index];  // O(1) operation
        System.out.println("Element at index " + index + " is: " + value);
    }
}

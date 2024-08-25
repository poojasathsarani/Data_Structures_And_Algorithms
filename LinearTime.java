public class LinearTime {
    public static void main(String[] args) {
        int[] array = {10, 20, 30, 40, 50};
        int max = array[0];
        
        for (int i = 1; i < array.length; i++) {  // O(n) operation
            if (array[i] > max) {
                max = array[i];
            }
        }
        
        System.out.println("Maximum element is: " + max);
    }
}

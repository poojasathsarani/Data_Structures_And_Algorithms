public class IndirectRecursion {

    // Method to check if a number is even using indirect recursion
    public static boolean isEven(int n) {
        // Base case: if n is 0, it is even
        if (n == 0) {
            return true;
        }
        // Recursive case: call isOdd with (n-1)
        return isOdd(n - 1);
    }

    // Method to check if a number is odd using indirect recursion
    public static boolean isOdd(int n) {
        // Base case: if n is 0, it is not odd
        if (n == 0) {
            return false;
        }
        // Recursive case: call isEven with (n-1)
        return isEven(n - 1);
    }

    public static void main(String[] args) {
        int number = 5; // Example input
        System.out.println("Is " + number + " even? " + isEven(number));
        System.out.println("Is " + number + " odd? " + isOdd(number));
    }
}

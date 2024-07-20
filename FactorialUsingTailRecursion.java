public class FactorialUsingTailRecursion {

    // Helper method to kick off the tail-recursive factorial calculation
    public static int factorial(int n) {
        return factorialTailRec(n, 1);
    }

    // Tail-recursive method for factorial calculation
    private static int factorialTailRec(int n, int accumulator) {
        // Base case: when n is 0, return the accumulated result
        if (n == 0) {
            return accumulator;
        }
        // Recursive case: pass the next value of n and the updated accumulator
        return factorialTailRec(n - 1, n * accumulator);
    }

    public static void main(String[] args) {
        int number = 5; // Example input
        int result = factorial(number); // Calculate factorial of the number
        System.out.println("Factorial of " + number + " is: " + result);
    }
}

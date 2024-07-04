import java.lang.*;

public class FactorialUsingDirectRecursion {

    // Method to calculate factorial using direct recursion
    public static int factorial(int n) {
        // Base case: factorial of 0 is 1
        if (n == 0) {
            return 1;
        }
        // Recursive case: n * factorial of (n-1)
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int number = 5; // Example input
        int result = factorial(number); // Calculate factorial of the number
        System.out.println("Factorial of " + number + " is: " + result);
    }
}

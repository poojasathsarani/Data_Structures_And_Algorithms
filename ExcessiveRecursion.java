public class ExcessiveRecursion {
    public static void main(String[] args) {
        int n = 30; // Change this value to test larger inputs
        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

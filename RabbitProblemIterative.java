public class RabbitProblemIterative {

    // Iterative method to calculate the number of rabbit pairs in the nth month
    public static int rabbitPopulationIterative(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }

        int previous = 1, current = 1;
        for (int i = 3; i <= n; i++) {
            int next = previous + current;
            previous = current;
            current = next;
        }
        return current;
    }

    public static void main(String[] args) {
        int months = 10; // Number of months
        for (int i = 1; i <= months; i++) {
            System.out.println("Month " + i + ": " + rabbitPopulationIterative(i) + " pairs of rabbits");
        }
    }
}

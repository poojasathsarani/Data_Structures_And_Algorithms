public class RabbitProblem {

    // Recursive method to calculate the number of rabbit pairs in the nth month
    public static int rabbitPopulationRecursive(int n) {
        // Base cases: 
        if (n == 1 || n == 2) {
            return 1;
        }
        // Recursive case:
        return rabbitPopulationRecursive(n - 1) + rabbitPopulationRecursive(n - 2);
    }

    public static void main(String[] args) {
        int months = 10; // Number of months
        for (int i = 1; i <= months; i++) {
            System.out.println("Month " + i + ": " + rabbitPopulationRecursive(i) + " pairs of rabbits");
        }
    }
}

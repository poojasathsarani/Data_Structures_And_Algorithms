public class TowerOfHanoi {

    // Recursive function to solve Tower of Hanoi puzzle
    public static void solveHanoi(int n, char source, char auxiliary, char destination) {
        // Base case: If there is only one disk, move it from source to destination
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }

        // Recursive case:
        // Step 1: Move the top n-1 disks from source to auxiliary, using destination as a temporary rod
        solveHanoi(n - 1, source, destination, auxiliary);

        // Step 2: Move the nth disk (the largest) from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Step 3: Move the n-1 disks from auxiliary to destination, using source as a temporary rod
        solveHanoi(n - 1, auxiliary, source, destination);
    }

    public static void main(String[] args) {
        int n = 3; // Number of disks
        solveHanoi(n, 'A', 'B', 'C'); // A, B, C are the names of the rods
    }
}

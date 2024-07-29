public class AckermannNestedRecursion {
    public static void main(String[] args) {
        int result = ackermann(3, 4);
        System.out.println("Ackermann(3, 4) = " + result);
    }

    public static int ackermann(int m, int n) {
        if (m == 0) {
            return n + 1;
        } else if (m > 0 && n == 0) {
            return ackermann(m - 1, 1);
        } else if (m > 0 && n > 0) {
            return ackermann(m - 1, ackermann(m, n - 1));
        }
        return -1; // Unreachable, added to satisfy the compiler
    }
}

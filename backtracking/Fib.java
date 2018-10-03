/**
 * Calculate fibonacci
 */
public class Fib {
    public static void main(String[] args) {
        System.out.println(fibDP(150));
        System.out.println(fib(150));
    }

    static int fib(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }

    static int fibDP(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] fibs = new int[n + 1];
        fibs[0] = 1;
        fibs[1] = 1;
        for (int i = 2; i <= n; i++) {
            fibs[i] = fibs[i - 1] + fibs[i - 2];
        }

        return fibs[n];

    }
}
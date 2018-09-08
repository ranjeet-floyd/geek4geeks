// Ranjeet Kumar
/**
 * Knight’s Tour problem. => The knight is placed on the first block of an empty
 * board and, moving according to the rules of chess, must visit each square
 * exactly once.
 */
public class KnightTour {
    private static int N = 8;

    public static void main(String[] args) {

        /**
         * while there are untried tours
         * <p>
         * { generate the next tour
         * <p>
         * if this tour covers all squares
         * <p>
         * { print this path; } }
         */

        solveKT();

    }

    private static boolean isSafe(int x, int y, int[][] sol) {
        return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);
    }

    private static void solution(int[][] sol) {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                System.out.println(sol[x][y] + " ");
            }

            System.out.println();

        }

    }

    private static void solveKT() {
        int[][] sol = new int[N][N];

        // Initailize solution matrix with -1
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                sol[x][y] = -1;
            }
        }

        /*
         * Possible move from any position
         */
        int[] yMove = { -1, -1, 1, 1, 2, -2, 2, -2 };
        int[] xMove = { -2, 2, 2, -2, -1, -1, 1, 1 };

        /* Start Knight from 0,0 */
        sol[0][0] = 0;

        if (solveKTUtils(0, 0, 1, sol, xMove, yMove)) {
            solution(sol);
        } else {
            System.out.println("No solution exist.");
        }

    }

    private static boolean solveKTUtils(int x, int y, int moveI, int[][] sol, int[] xMove, int[] yMove) {

        /* Base condition */
        if (moveI == N * N) {
            return true;
        }
        int xNext, yNext;
        /* Try all next move from current position */
        for (int k = 0; k < N; k++) {
            xNext = x + xMove[k];
            yNext = y + yMove[k];

            /* Check if position if safe */
            if (isSafe(xNext, yNext, sol)) {
                sol[xNext][yNext] = moveI;
                if (solveKTUtils(xNext, yNext, moveI + 1, sol, xMove, yMove)) {
                    return true;
                } else {
                    sol[xNext][yNext] = -1; // no path
                }

            }
        }

        return false;

    }

}
/**
 * Ranjeet
 * <p>
 * A Maze is given as N*N binary matrix of blocks where source block is the
 * upper left most block i.e., maze[0][0] and destination block is lower
 * rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to
 * reach the destination. The rat can move only in two directions: forward and
 * down.In the maze matrix, 0 means the block is a dead end and 1 means the
 * block can be used in the path from source to destination.
 * <p>
 * {1, 0, 0, 0}
 * <p>
 * {1, 1, 0, 1}
 * <p>
 * {0, 1, 0, 0}
 * <p>
 * {1, 1, 1, 1}
 * <p>
 **/

public class RatInMaze {
    private static int M = 4;
    private static int N = 4;

    public static void main(String[] args) {
        System.out.println("Hello Rat");
        int maze[][] = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 0, 1, 0, 0 }, { 1, 1, 1, 1 } };

        findPath(maze, 0, 0);

    }

    /*
     * 0 means the block is a dead
     */
    private static boolean isSafe(int x, int y, int[][] maze) {
        return (x >= 0 && x < M && y >= 0 && y < N && maze[x][y] == 1);
    }

    private static void printSol(int[][] sol) {
        for (int x = 0; x < M; x++) {
            for (int y = 0; y < N; y++) {
                System.out.print(" " + sol[x][y] + " ");
            }

            System.err.println();

        }
    }

    private static void findPath(int[][] maze, int x, int y) {
        int[][] sol = new int[M][N];
        // printSol(sol);
        if (mazeUtils(maze, x, y, sol)) {
            printSol(sol);
        } else {
            System.err.println("No path exists.");
        }

    }

    private static boolean mazeUtils(int[][] maze, int x, int y, int[][] sol) {
        // base condition
        if (x == M - 1 && y == N - 1) {
            sol[x][y] = 1;
            return true;
        }

        if (isSafe(x, y, maze)) {
            sol[x][y] = 1;
            if (mazeUtils(maze, x + 1, y, sol)) {
                return true;
            }
            if (mazeUtils(maze, x, y + 1, sol)) {
                return true;
            }
            sol[x][y] = 0;
            return false;

        }

        return false;

    }

}
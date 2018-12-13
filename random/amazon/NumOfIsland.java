/**
 * @author ranjeet
 * Find the number of islands
 * Input : mat[][] = {{1, 1, 0, 0, 0},
                   {0, 1, 0, 0, 1},
                   {1, 0, 0, 1, 1},
                   {0, 0, 0, 0, 0},
                   {1, 0, 1, 0, 1} 
Output : 5
 **/

public class NumOfIsland {
    static final int ROW = 5;
    static final int COL = 5;
    static final int rowNum[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static final int colNum[] = { -1, 0, 1, 1, -1, -1, 0, 1 };

    public static void main(String[] args) {
        System.out.println("Find the number of islands");

        int[][] arr = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };
        System.out.println("No of Islands : " + countIslands(arr));
    }

    /**
     * Count number of islands 
     * @param arr
     * @return
     */
    static int countIslands(int[][] arr) {
        boolean[][] visited = new boolean[ROW][COL];
        int countIslands = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (isSafe(arr, i, j, visited)) {
                    DFS(arr, i, j, visited);
                    countIslands++;
                }
            }
        }
        return countIslands;
    }

    /**
     * utility funcation to DFS on 2D array
     * 
     * @param arr
     * @param row
     * @param col
     * @param visited
     */
    static void DFS(int[][] arr, int row, int col, boolean[][] visited) {
        System.out.println("Called DFS => row : "+row  + " and col:"+col);
        // mark visited cell true
        visited[row][col] = true;
        // recur for all connected nodes
        for (int k = 0; k < 8; k++) {
            // check if safe
            if (isSafe(arr, row + rowNum[k], col + colNum[k], visited)) {
                DFS(arr, row + rowNum[k], col + colNum[k], visited);
            }
        }

    }

    /**
     * Check if safe arr[row][col]
     * 
     * @param arr
     * @param row
     * @param col
     * @param visited
     * @return true if safe
     */
    static boolean isSafe(int[][] arr, int row, int col, boolean[][] visited) {
        System.out.println("row : "+ row + " col :" + col);
        return row < ROW && row >= 0 && col < COL && col >= 0 && arr[row][col] == 1 && !visited[row][col];

    }
 }
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
    static final int LAND = 1;
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
        int ROW = arr.length; //row
        int COL = arr[0].length; //col
        boolean[][] visited = new boolean[ROW][COL];
        int countOfIsland = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (isSafe(arr, i, j, visited, ROW, COL)) {
                    DFS(arr, i, j, visited, ROW, COL);
                    countOfIsland++;
                }
            }
        
        }

        return countOfIsland;
    }

    /**
     * utility funcation to DFS on 2D array
     * | recursive
     * @param arr
     * @param row
     * @param col
     * @param visited
     */
    static void DFS(int[][] arr, int row, int col, boolean[][] visited, int ROW, int COL) {
        if (isSafe(arr, row, col, visited, ROW, COL)) {
            visited[row][col] = true;
            for (int k = 0; k < 8; k++) {
                DFS(arr, row + rowNum[k], col + colNum[k], visited, ROW, COL);
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
    static boolean isSafe(int[][] arr, int row, int col, boolean[][] visited , int ROW, int COL) {
       return row >=0 && row < ROW
       && col >=0  && col < COL
       && (arr[row][col] == LAND)
       && !visited[row][col];

    }
 }
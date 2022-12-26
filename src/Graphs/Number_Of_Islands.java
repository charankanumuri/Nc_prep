package Graphs;

/**
 * Number_Of_Islands
 */
public class Number_Of_Islands {

    public int numberOfIslands(char[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int noOfIslands = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    noOfIslands++;
                    dfs(grid, i, j, rows, cols);
                }
            }
        }
        return noOfIslands;
    }

    public void dfs(char[][] grid, int row, int col, int rows, int cols) {
        if (row < 0 || row == rows || col < 0 || col == cols || grid[row][col] == '0')
            return;

        grid[row][col] = '0';
        dfs(grid, row - 1, col, rows, cols);
        dfs(grid, row + 1, col, rows, cols);
        dfs(grid, row, col - 1, rows, cols);
        dfs(grid, row, col + 1, rows, cols);
    }
}
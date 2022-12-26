package Graphs;

public class Max_Area_Island {

    int count;

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    count = 0;
                    maxArea = Math.max(maxArea, dfs(grid, i, j, rows, cols));
                }
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int row, int col, int rows, int cols) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == 0)
            return count;
        count++;
        grid[row][col] = 0;
        dfs(grid, row - 1, col, rows, cols);
        dfs(grid, row + 1, col, rows, cols);
        dfs(grid, row, col - 1, rows, cols);
        dfs(grid, row, col + 1, rows, cols);
        return count;
    }
}

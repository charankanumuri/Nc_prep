package Graphs;

public class Surrounded_Regions {

    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        // Capture unsurrounded boundary regions - top and bottom row (O -> T)
        for (int i = 0; i < cols; i++) {
            if (board[0][i] == 'O')
                dfs(board, 0, i, rows, cols);
            if (board[rows - 1][i] == 'O')
                dfs(board, rows - 1, i, rows, cols);
        }

        // Capture unsurrounded boundary regions - Left and Right Col (O -> T)
        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O')
                dfs(board, i, 0, rows, cols);
            if (board[i][cols - 1] == 'O')
                dfs(board, i, cols - 1, rows, cols);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X'; // cells that can be captured
                if (board[i][j] == 'T')
                    board[i][j] = 'O'; // cells that cannot be captured
            }
        }
    }

    public void dfs(char[][] board, int row, int col, int rows, int cols) {
        if (row < 0 || row >= rows || col < 0 || col >= cols || board[row][col] != 'O')
            return;

        board[row][col] = 'T';
        dfs(board, row + 1, col, rows, cols);
        dfs(board, row - 1, col, rows, cols);
        dfs(board, row, col + 1, rows, cols);
        dfs(board, row, col - 1, rows, cols);
    }
}

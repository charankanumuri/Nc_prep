package Arrays_Hashing;

import java.util.HashSet;

public class Validate_Sudoku {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        int rows = board.length, cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] != '.') {
                    if (!set.add(board[i][j] + " is present in box " + i / 3 + " x " + j / 3)
                            || !set.add(board[i][j] + " is present in row " + i)
                            || !set.add(board[i][j] + " is present in col " + j))
                        return false;
                }
            }
        }

        return true;
    }
}

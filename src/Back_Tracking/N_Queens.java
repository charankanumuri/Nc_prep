package Back_Tracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class N_Queens {
    
    

    public static List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++)
                board[i][j] = '.';
        }

        List<List<String>> res = new ArrayList<List<String>>();
        dfs(board, 0, res);
        return res;
    }

    public static void dfs(char[][] board, int col, List<List<String>> res) {

        if(col >= board.length) {
            res.add(construct(board));
            return;
        }
        
        for(int i = 0; i < board.length; i++) {
            if(isSafe(board, i, col)) {
                board[i][col] = 'Q';
                dfs(board, col + 1, res);
                board[i][col] = '.';
            }
        }

    }

    public static boolean isSafe(char[][] board, int row, int col) {
        int i, j;

        /* Check this row on left side */
        for(i = 0; i < col; i++) {
            if(board[row][i] == 'Q')
                return false;
        }

        /* Check upper diagonal on left side */
        for(i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(board[i][j] == 'Q')
                return false;
        }

        /* Check lower diagonal on left side */
        for(i = row, j = col; j >= 0 && i < board.length; j--, i++) {
            if(board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    private static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }


    public static void main(String[] args) {
        int n = 4;
        List<List<String>> res = solveNQueens(n);
        for(List<String> r: res) {
            System.out.println(r.toString());
        }
    }
}

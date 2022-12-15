package Back_Tracking;

/* Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.

 

Example 1:


Input: board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCCED'
Output: true
Example 2:


Input: board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'SEE'
Output: true
Example 3:


Input: board = [['A','B','C','E'],['S','F','C','S'],['A','D','E','E']], word = 'ABCB'
Output: false
 

Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters. */

public class Word_Search {

    public static boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, int row, int col, String word, int index) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length
                || word.charAt(index) != board[row][col] || board[row][col] == '#')
            return false;
        
        if(index == word.length() - 1)
            return true;

        char ch = board[row][col];
        board[row][col] = '#';
        boolean exists = dfs(board, row + 1, col, word, index + 1) || dfs(board, row, col + 1, word, index + 1)
                || dfs(board, row - 1, col, word, index + 1) || dfs(board, row, col - 1, word, index + 1);
            
        if(exists) 
            return true;
        
        board[row][col] = ch;
        return false;
    }

    public static void main(String[] args) {
       char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
       String word = "ABCE";    

       System.out.println(exist(board, word));
    }

}

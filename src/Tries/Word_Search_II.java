package Tries;

import java.util.ArrayList;
import java.util.List;

public class Word_Search_II {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Trie root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++)
                dfs(board, i, j, root, res);
        }
        return res;
    }

    public void dfs(char[][] board, int row, int col, Trie curr, List<String> res) {
        char ch = board[row][col];
        if (ch == '#' || curr.next[ch - 'a'] == null)
            return;
        curr = curr.next[ch - 'a'];
        if (curr.word != null) {
            res.add(curr.word);
            curr.word = null;
        }
        board[row][col] = '#';
        if (row > 0) dfs(board, row - 1, col, curr, res);
        if (row < board.length - 1) dfs(board, row + 1, col, curr, res);
        if (col > 0) dfs(board, row, col - 1, curr, res);
        if (col < board[0].length - 1) dfs(board, row, col + 1, curr, res);
        board[row][col] = ch;
    }

    public Trie buildTrie(String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            Trie temp = root;
            for (char ch : word.toCharArray()) {
                if (temp.next[ch - 'a'] == null)
                    temp.next[ch - 'a'] = new Trie();
                temp = temp.next[ch - 'a'];
            }
            temp.word = word;
        }
        return root;
    }

    class Trie {
        Trie[] next = new Trie[26];
        String word;
    }
}

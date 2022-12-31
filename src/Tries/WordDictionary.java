package Tries;

public class WordDictionary {

    Node root;

    public WordDictionary() {
        root = new Node('\0');
    }

    public void addWord(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            if (curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new Node(ch);
            curr = curr.children[ch - 'a'];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(root, word, 0);
    }

    public boolean searchHelper(Node curr, String word, int index) {
        for (int i = index; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') {
                for (Node temp : curr.children) {
                    if (temp != null && searchHelper(temp, word, i + 1))
                        return true;
                }
                return false;
            }
            if (curr.children[ch - 'a'] == null) {
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return curr.isWord;
    }

    class Node {
        char ch;
        boolean isWord;
        Node[] children;

        public Node(char c) {
            ch = c;
            isWord = false;
            children = new Node[26];
        }
    }
}

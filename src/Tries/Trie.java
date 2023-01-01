package Tries;

public class Trie {

    Node root;

    public Trie() {
        root = new Node('\0');
    }
    
    public void insert(String word) {
        Node curr = root;
        for(char ch: word.toCharArray()) {
            if(curr.children[ch - 'a'] == null)
                curr.children[ch - 'a'] = new Node(ch);
            curr = curr.children[ch - 'a'];
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        Node node = getLast(word);
        return node != null && node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        Node node = getLast(prefix);
        if (node == null) 
            return false;
        return true;
    }

    public Node getLast(String word) {
        Node curr = root;
        for(char ch: word.toCharArray()) {
            if (curr.children[ch - 'a'] == null)
                return null;
            curr = curr.children[ch - 'a'];
        }
        return curr;
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
package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Clone_Graph {

    Map<Integer, Node> oldToNewMap = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;

        if (oldToNewMap.containsKey(node.val))
            return oldToNewMap.get(node.val);

        Node copy = new Node(node.val, new ArrayList<Node>());
        oldToNewMap.put(node.val, copy);
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));
        }

        return copy;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

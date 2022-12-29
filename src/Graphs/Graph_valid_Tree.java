package Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Graph_valid_Tree {

    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        Set<Integer> vis = new HashSet<>();
        
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        
        for(int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        // We return true iff no cycles were detected,
        // AND the entire graph has been reached.
        return dfs(0, -1, adj, vis) && vis.size() == n;
    }
    
    
    public boolean dfs(int node, int parent, List<List<Integer>> adj, Set<Integer> vis) {
        if(vis.contains(node))
            return false;
        
        vis.add(node);
        for(Integer neighbor: adj.get(node)) {
            if(neighbor != parent) {
                if(!dfs(neighbor, node, adj, vis))
                    return false;
            }
        }
        
        return true;
    }
    
    // to be verified.
    public boolean bfs(int node, int v, List<List<Integer>> adj, Set<Integer> vis) {
        
        Queue<int[]> q = new LinkedList<>();
        vis.add(node);
        
        q.add(new int[]{node, -1});
        
        while(!q.isEmpty()) {
            int[] vertex = q.poll();
            for(Integer neighbor: adj.get(vertex[0])) {
                if(!vis.contains(neighbor)) {
                    q.add(new int[]{neighbor, vertex[0]});
                    vis.add(neighbor);
                } else if(neighbor != vertex[1])
                    return false;
            }
        }
        return true;
    }
}

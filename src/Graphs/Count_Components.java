package Graphs;

import java.util.ArrayList;
import java.util.List;

/**
 You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

Return the number of connected components in the graph.

 

Example 1:


Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2
Example 2:


Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1
 

Constraints:

1 <= n <= 2000
1 <= edges.length <= 5000
edges[i].length == 2
0 <= ai <= bi < n
ai != bi
There are no repeated edges.*/
public class Count_Components {


    public int countComponents(int n, int[][] edges) {
        int noOfComponents = 0;
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<Integer>());
        
        for(int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        
        int[] vis = new int[n];
        for(int i = 0; i < n; i++) {
            if(vis[i] == 0) {
                noOfComponents++;
                dfs(adj, i, vis);
            }
        }
        
        return noOfComponents;
    }
    
    public void dfs(List<List<Integer>> adj, int start, int[] vis) {
        vis[start] = 1;
        
        for(Integer neighbor: adj.get(start)) {
            if(vis[neighbor] == 0)
                dfs(adj, neighbor, vis);
        }
    }
    
}
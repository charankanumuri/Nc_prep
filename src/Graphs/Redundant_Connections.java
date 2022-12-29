package Graphs;

public class Redundant_Connections {

    static int[] par;
    static int[] rank;

    public static int[] findRedundantConnection(int[][] edges) {
        par = new int[edges.length + 1];
        rank = new int[edges.length + 1];
        for (int i = 0; i < edges.length; i++) {
            par[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1]))
                return edge;
        }
        return new int[0];
    }

    public static int find(int x) {
        if (par[x] != x)
            par[x] = find(par[x]);
        return par[x];
    }

    public static boolean union(int x, int y) {
        int par_x = find(x), par_y = find(y);
        if (par_x == par_y) {
            return false;
        } else if (rank[par_x] < rank[par_y]) {
            par[par_x] = par_y;
            rank[par_y] += rank[par_x];
        } else if (rank[par_x] >= rank[par_y]) {
            par[par_y] = par_x;
            rank[par_x] += rank[par_y];
        }
        return true;
    }

    public static void main(String[] args) {
        // int[][] edges = {{1,2},{1,3},{2,3}};
        int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
        for(int edge: findRedundantConnection(edges))
            System.out.println(edge);
    }
}
package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pacific_Atlantic_Flow {
    
    static int[][] dirs = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    
    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        
        LinkedList<int[]> atlantic = new LinkedList<>();
        LinkedList<int[]> pacific = new LinkedList<>();

        if(heights == null || heights.length == 0)
            return res;
        
        int rows = heights.length;
        int cols = heights[0].length;

        for(int i = 0; i < cols; i++) {
            atlantic.add(new int[]{rows - 1, i});
            pacific.add(new int[]{0, i});
        }

        for(int i = 0; i < rows; i++) {
            atlantic.add(new int[]{i, cols - 1});
            pacific.add(new int[]{i, 0});
        }

        boolean[][] pacificVis = new boolean[heights.length][heights[0].length];
        boolean[][] atlanticVis = new boolean[heights.length][heights[0].length];

        bfs(atlantic, atlanticVis, heights);
        bfs(pacific, pacificVis, heights);
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(pacificVis[i][j] && atlanticVis[i][j])
                    res.add(Arrays.asList(i, j));
            }
        }
        
        return res;
    }

    public static void bfs(Queue<int[]> queue, boolean[][] vis, int[][] heights) {

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();

            vis[cell[0]][cell[1]] = true;

            for(int[] dir: dirs) {
                int row = dir[0] + cell[0];
                int col = dir[1] + cell[1];

                if(row < 0 || col < 0 || row >= heights.length || col >= heights[0].length || vis[row][col] == true)
                    continue;
                
                if(heights[cell[0]][cell[1]] <= heights[row][col])
                    queue.add(new int[]{row, col});
            }
        }
    }

    public static void main(String[] args) {
        int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        List<List<Integer>> res = pacificAtlantic(heights);
        for(List<Integer> l: res) {
            System.out.println(l.toString());
        }
    }
}

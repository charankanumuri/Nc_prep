package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Rotting_Oranges {
    
    public static int rottingOranges(int[][] grid) {
        if(grid == null || grid.length == 0)
            return -1;

        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1)
                    fresh++;
                else if(grid[i][j] == 2)
                    queue.add(new int[]{i, j});
            }
        }

        if(fresh == 0)
            return 0;

        int timestamp = 0;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while(!queue.isEmpty()) {
            int size = queue.size();
            timestamp++;
            for(int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                for(int[] dir: dirs) {
                    int row = dir[0] + rotten[0];
                    int col = dir[1] + rotten[1];
                    if(row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] != 1)
                        continue;
                    
                    grid[row][col] = 2;
                    queue.add(new int[]{row, col});
                    fresh--;
                }
            }
        }
        return fresh == 0 ? timestamp - 1 : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        // int[][] grid = {{0,2}};
        System.out.println(rottingOranges(grid));
    }
}

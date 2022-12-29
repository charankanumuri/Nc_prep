package Graphs;

import java.util.LinkedList;
import java.util.Queue;

/* You are given an m x n grid rooms initialized with these three possible values.

-1 A wall or an obstacle.
0 A gate.
INF Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

Input: rooms = [[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]
Output: [[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]
Example 2:

Input: rooms = [[-1]]
Output: [[-1]]
 

Constraints:

m == rooms.length
n == rooms[i].length
1 <= m, n <= 250
rooms[i][j] is -1, 0, or 231 - 1.   */

public class Walls_And_Gates {
    
    int[][] dirs = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
    
    public void wallsAndGates(int[][] rooms) {

        int rows = rooms.length, cols = rooms[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(rooms[i][j] == 0)
                    queue.add(new int[]{i, j});
            }
        }

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for(int[] dir: dirs) {
                    int row = dir[0] + cell[0];
                    int col = dir[1] + cell[1];

                    if(row < 0 || row >= rows || col < 0 || col >= cols || rooms[row][col] != Integer.MAX_VALUE)
                        continue;
                    
                    rooms[row][col] = rooms[cell[0]][cell[1]] + 1;
                    queue.add(new int[]{row, col});
                }
            }
        }
    }
}

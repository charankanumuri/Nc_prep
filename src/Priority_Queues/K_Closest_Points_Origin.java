package Priority_Queues;

import java.util.PriorityQueue;

public class K_Closest_Points_Origin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));

        for (int[] point : points)
            pq.add(point);

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] curr = pq.poll();
            ans[i][0] = curr[0];
            ans[i][1] = curr[1];
        }
        return ans;
    }
}

package Priority_Queues;

import java.util.PriorityQueue;

public class Kth_Largest_In_Array {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k)
                pq.poll();
        }

        return pq.peek();
    }
}
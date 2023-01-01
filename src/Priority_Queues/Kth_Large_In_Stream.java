package Priority_Queues;

import java.util.PriorityQueue;

public class Kth_Large_In_Stream {
    
    PriorityQueue<Integer> pq;
    int k;
    public Kth_Large_In_Stream(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for(int num: nums)
            add(num); 
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }

}

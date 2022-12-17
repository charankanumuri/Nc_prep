package Arrays_Hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Top_K_Frequent_Elements {
    
    public static int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
            if(pq.size() > k)
                pq.poll();
        }

        int i = k;
        while(!pq.isEmpty()) {
            arr[--i] = pq.poll().getKey();
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 3, 4, 4, 1, 1, 1};
        int[] arr = topKFrequent(nums, 3);
        for(int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

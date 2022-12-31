package Priority_Queues;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Task_Scheduler {
    
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int[] arr = new int[26];
        for(char ch: tasks)
            arr[ch - 'A']++;
        
        for(int i = 0; i < 26; i++) {
            if(arr[i] > 0)
                pq.add(arr[i]);
        }

        Queue<int[]> queue = new LinkedList<>();
        int time = 0;
        while(!pq.isEmpty() || !queue.isEmpty()) {
            time++;
            if(!pq.isEmpty()) {
                int count = pq.poll();
                count--;
                if(count > 0)
                    queue.add(new int[]{count, time + n});
            }

            if(!queue.isEmpty() && queue.peek()[1] == time)
                pq.add(queue.poll()[0]);
        }
        return time;
    }
}

package Priority_Queues;

import java.util.PriorityQueue;

public class Last_Stone_Weight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int stone : stones)
            maxHeap.add(stone);

        while (maxHeap.size() > 1) {
            int firstStone = maxHeap.remove();
            int secondStone = maxHeap.remove();
            if (firstStone != secondStone)
                maxHeap.add(firstStone - secondStone);

        }

        return maxHeap.size() != 0 ? maxHeap.remove() : 0;
    }
}

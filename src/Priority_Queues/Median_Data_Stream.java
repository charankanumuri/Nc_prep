package Priority_Queues;

import java.util.PriorityQueue;

public class Median_Data_Stream {

    PriorityQueue<Integer> smallHeap;
    PriorityQueue<Integer> largeHeap;

    public Median_Data_Stream() {
        smallHeap = new PriorityQueue<>((a, b) -> b - a);
        largeHeap = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        smallHeap.add(num);

        if (!largeHeap.isEmpty() || smallHeap.size() - largeHeap.size() > 1)
            largeHeap.add(smallHeap.poll());

        if (largeHeap.size() - smallHeap.size() > 1)
            smallHeap.add(largeHeap.poll());

    }

    public double findMedian() {
        if (smallHeap.size() == largeHeap.size())
            return (double) (largeHeap.peek() + smallHeap.peek()) / 2;

        else if (smallHeap.size() > largeHeap.size())
            return smallHeap.peek();

        else
            return largeHeap.peek();
    }
}

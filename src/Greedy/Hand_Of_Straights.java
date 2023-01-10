package Greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Hand_Of_Straights {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0)
            return false;

        Map<Integer, Integer> map = new HashMap<>();
        for (int num : hand)
            map.put(num, map.getOrDefault(num, 0) + 1);

        Arrays.sort(hand);
        for (int h : hand) {
            if (map.get(h) <= 0)
                continue;
            for (int i = 1; i < groupSize; i++) {
                int count = map.getOrDefault(h + i, 0);
                if (count > 0)
                    map.put(h + i, count - 1);
                else
                    return false;
            }
            map.put(h, map.get(h) - 1);
        }
        return true;
    }
}

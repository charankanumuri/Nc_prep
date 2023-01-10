package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Partition_Labels {

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        // map to store the last index of each present character in s
        // max space: O(26) and T.C: O(n) where n = s.length()
        for (int i = 0; i < s.length(); i++)
            map.put(s.charAt(i), i);

        int start = 0;
        int end = 0;
        while (start < s.length()) {
            int count = 0;
            end = Math.max(end, map.get(s.charAt(start)));
            while (start <= end) {
                end = Math.max(end, map.get(s.charAt(start)));
                count++;
                start++;
            }
            res.add(count);
        }
        return res;
    }

}

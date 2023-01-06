package Sliding_Window;

import java.util.HashMap;
import java.util.Map;

public class Longest_Substr_No_Rep {
    
    public int lengthOfLongestSubstring(String s) {
        int windowStart = 0, iter = 0;
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;

        while(iter < s.length()) {
            char ch = s.charAt(iter);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if(map.get(ch) > 1) {
                char windowChar = s.charAt(windowStart);
                map.put(windowChar, map.get(windowChar) - 1);
                windowChar++;
            }
            res = Math.max(res, iter - windowStart + 1);
            iter++;
        }
        return res;
    }
}

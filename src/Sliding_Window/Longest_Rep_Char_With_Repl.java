package Sliding_Window;

public class Longest_Rep_Char_With_Repl {
    
    public int characterReplacement(String s, int k) {
        int res = 0, left = 0, maxF = 0;
        int[] arr = new int[26];
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            arr[ch - 'A']++;
            maxF = Math.max(maxF, arr[ch - 'A']);
            int windowLen = i - left + 1;
            if(windowLen - maxF > k) {
                arr[s.charAt(left) - 'A']--;
                left++;
            }
            windowLen = i - left + 1;
            res = Math.max(res, windowLen);
        }
        return res;
    }
}

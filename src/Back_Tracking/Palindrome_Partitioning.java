package Back_Tracking;

import java.util.ArrayList;
import java.util.List;


/* Given a string s, partition s such that every 
substring of the partition is a palindrome.
Return all possible palindrome partitioning of s.
 

Example 1:

Input: s = "aab"
Output: [["a","a","b"],["aa","b"]]
Example 2:

Input: s = "a"
Output: [["a"]]
 

Constraints:

1 <= s.length <= 16
s contains only lowercase English letters. */


public class Palindrome_Partitioning {
    
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        recursive_call(res, new ArrayList<>(), s, 0);
        return res;
    }

    public static void recursive_call(List<List<String>> res, List<String> curr, String s, int index) {

        if(index == s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = index; i < s.length(); i++) {
            if(isPalindrome(s, index, i)) {
                curr.add(s.substring(index, i + 1));
                recursive_call(res, curr, s, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public static boolean isPalindrome(String s, int start, int end) {
        while(start <= end) {
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> res = partition(s);

        for(List<String> l: res) {
            System.out.println(l.toString());
        }
    }
    
}

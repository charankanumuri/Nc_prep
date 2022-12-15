package Back_Tracking;

import java.util.ArrayList;
import java.util.List;

/* Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.

 

Example 1:

Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
Example 2:

Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
 

Constraints:

1 <= n <= 20
1 <= k <= n */

public class Combinations {
    

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        recursive_call(res, new ArrayList<>(), 1, n, k);
        return res;
    }


    public static void recursive_call(List<List<Integer>> res, List<Integer> curr, int index, int n, int k) {
        if(k == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for(int i = index; i <= n; i++) {
            curr.add(i);
            recursive_call(res, curr, i + 1, n, k - 1);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 3;
        List<List<Integer>> result = combine(n, k);

        for (List<Integer> l : result) {
            System.out.println(l.toString());
        }
    }

    
}

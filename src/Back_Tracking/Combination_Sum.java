package Back_Tracking;

import java.util.ArrayList;
import java.util.List;

/* Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the 
frequency
 of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

 

Example 1:

Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.
Example 2:

Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]
Example 3:

Input: candidates = [2], target = 1
Output: []
 

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40 */

public class Combination_Sum {

    static List<List<Integer>> res;

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        recursive_call(candidates, target, 0, new ArrayList<>());
        return res;
    }

    public static void recursive_call(int[] candidates, int target, int index, List<Integer> list) {

        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (target > 0) {
            // since the same number can taken any number of times
            for (int i = index; i < candidates.length; i++) {
                list.add(candidates[i]);
                recursive_call(candidates, target - candidates[i], i, list);
                list.remove(list.size() - 1);
            }
        }

    }

    public static void main(String[] args) {

        int[] candidates = { 2, 3, 6, 7, 1 };
        int target = 8;

        List<List<Integer>> result = combinationSum(candidates, target);

        for (List<Integer> l : result) {
            System.out.println(l.toString());
        }

    }
}

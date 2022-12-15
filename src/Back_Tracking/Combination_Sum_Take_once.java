package Back_Tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

Each number in candidates may only be used once in the combination.

Note: The solution set must not contain duplicate combinations.

 

Example 1:

Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: 
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output: 
[
[1,2,2],
[5]
]
 

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30 */

public class Combination_Sum_Take_once {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        recursive_call(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }

    public static void recursive_call(List<List<Integer>> res, List<Integer> curr, int[] candidates, int target,
            int index) {

        if (target == 0) {
            if (!res.contains(curr))
                res.add(new ArrayList<>(curr));
            return;
        }

        if (target > 0) {
            for (int i = index; i < candidates.length; i++) {
                if (i > index && candidates[i] == candidates[i - 1])
                    continue;
                curr.add(candidates[i]);
                recursive_call(res, curr, candidates, target - candidates[i], i + 1);
                curr.remove(curr.size() - 1);
            }
        }

    }

    public static void main(String[] args) {

        int[] candidates = { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1 };
        int target = 30;

        List<List<Integer>> result = combinationSum2(candidates, target);

        for (List<Integer> l : result) {
            System.out.println(l.toString());
        }

    }
}

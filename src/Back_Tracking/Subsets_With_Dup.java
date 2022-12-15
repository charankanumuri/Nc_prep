package Back_Tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/* Given an integer array nums that may contain duplicates, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10 */

public class Subsets_With_Dup {
    
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        recursive_call(res, new ArrayList<>(), nums, 0);
        return res;
    }

    public static void recursive_call(List<List<Integer>> res, List<Integer> curr, int[] nums, int index) {

        res.add(new ArrayList<>(curr));

        for(int i = index; i < nums.length; i++) {
            if(i != index && nums[i] == nums[i - 1])
                continue;
            
            curr.add(nums[i]);
            recursive_call(res, curr, nums, i + 1);
            curr.remove(curr.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = { 2, 4, 2 };
        List<List<Integer>> result = subsetsWithDup(nums);

        for (List<Integer> l : result) {
            System.out.println(l.toString());
        }
    }
}

package Back_Tracking;

import java.util.ArrayList;
import java.util.List;

/* Given an integer array nums of unique elements, return all possible 
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]
 

Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique. */

public class Subsets {

    static List<List<Integer>> res;

    public static List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        recursive_call(nums, 0, new ArrayList<>());
        return res;
    }

    public static void recursive_call(int[] nums, int index, List<Integer> list) {

        if (index >= nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        list.add(nums[index]); // take the num
        recursive_call(nums, index + 1, list);

        list.remove(list.size() - 1); // remove (Not Take) the num
        recursive_call(nums, index + 1, list);

    }

    public static void main(String[] args) {
        int[] nums = { 0, 2, 4, 6 };
        List<List<Integer>> result = subsets(nums);

        for (List<Integer> l : result) {
            System.out.println(l.toString());
        }
    }

}

package Back_Tracking;

import java.util.ArrayList;
import java.util.List;


/* Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

 

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]
 

Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique. */

public class Permutations {
    

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        recursive_call(res, nums, 0);
        return res;
    }

    public static void recursive_call(List<List<Integer>> res, int[] nums, int index) {

        if(index == nums.length) {
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < nums.length; i++) {
                list.add(nums[i]);
            }
            res.add(list);
            return;
        }

        for(int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            recursive_call(res, nums, index + 1);
            swap(nums, index, i);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 4, 6 };
        List<List<Integer>> result = permute(nums);

        for (List<Integer> l : result) {
            System.out.println(l.toString());
        }
    }
}

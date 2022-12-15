package Back_Tracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/* Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.

 

Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 

Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10 */

public class Permute_Unique {
    
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length == 0)
            return res;
        recursive_call(res, nums, 0);
        return res;
    }

    public static void recursive_call(List<List<Integer>> res, int[] nums, int index) {

        if(nums.length == index) {
            List<Integer> curr = new ArrayList<>();
            for(int i = 0; i < nums.length; i++)
                curr.add(nums[i]);
            res.add(new ArrayList<>(curr));
            return;
        }

        Set<Integer> set = new HashSet<>();
        for(int i = index; i < nums.length; i++) {
            if(set.add(nums[i])) {
                swap(nums, index, i);
                recursive_call(res, nums, index + 1);
                swap(nums, index, i);
            }
        }

    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 2, 6 };
        List<List<Integer>> result = permuteUnique(nums);

        for (List<Integer> l : result) {
            System.out.println(l.toString());
        }
    }
    
}

package Arrays_Hashing;

import java.util.HashSet;

public class Longest_Consecutive_Seq {

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0)
            return 0;
        HashSet<Integer> set = new HashSet<>();
        int res = 1;
        for (int num : nums)
            set.add(num);

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int count = 1;
                while (set.contains(num + 1)) {
                    num++;
                    count++;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };

        System.out.println(longestConsecutive(nums));
    }

}

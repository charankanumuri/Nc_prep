package Greedy;

public class Jump_Game {

    // Time complexity : O(n). 
    public boolean canJump(int[] nums) {
        int end = nums.length - 1;
        for (int i = end - 1; i >= 0; i--) {
            if (nums[i] >= end - i)
                end = i;
        }
        return end == 0;
    }

    enum Index {
        GOOD, BAD, UNKNOWN
    }

    /* Time complexity : O(n2). 
    For every element in the array, say i, we are looking at the next nums[i] elements to its right aiming to find a GOOD index. nums[i] can be at most n, where n is the length of array nums.
    Space complexity : O(n). This comes from the usage of the memo table. */
    public boolean canJumpDP(int[] nums) {
        Index[] memo = new Index[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = Index.UNKNOWN;
        }
        memo[memo.length - 1] = Index.GOOD;

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == Index.GOOD) {
                    memo[i] = Index.GOOD;
                    break;
                }
            }
        }

        return memo[0] == Index.GOOD;
    }
}

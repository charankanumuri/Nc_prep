package Greedy;

public class Jump_Game_II {

    public int jump(int[] nums) {
        int res = 0;
        int left = 0, right = 0;
        int len = nums.length - 1;
        while (right < len) {
            int farthest = 0;
            for (int i = left; i < right + 1; i++)
                farthest = Math.max(farthest, i + nums[i]);

            left = right + 1;
            right = farthest;
            res++;
        }
        return res;
    }
}

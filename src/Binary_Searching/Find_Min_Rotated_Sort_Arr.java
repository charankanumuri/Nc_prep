package Binary_Searching;

public class Find_Min_Rotated_Sort_Arr {

    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1])
                return nums[mid];
            // [4,5,6, 7 ,0,1,2]
            else if (nums[left] <= nums[mid] && nums[mid] > nums[right])
                left = mid + 1;
            // [0,1,2, 4 ,5,6,7]
            else
                right = mid - 1;
        }
        return nums[left];
    }

}

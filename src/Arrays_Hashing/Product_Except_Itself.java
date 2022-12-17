package Arrays_Hashing;

public class Product_Except_Itself {
    
    public static int[] productExceptSelf(int[] nums) {
        int left = 1, right = 1;
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            arr[i] = left;
            left *= nums[i];
        }

        for(int i = nums.length - 1; i >= 0; i--) {
            arr[i] *= right;
            right *= nums[i];
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        int[] res = productExceptSelf(nums);
        for(int i: res)
            System.out.println(i);
    }

}

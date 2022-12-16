package Back_Tracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Program to list the sums of all the subsets for a given array of integers
// Eg: arr = [1, 3, 2, 4]
// output: [10, 6, 7, 3, 8, 4, 5, 1, 9, 5, 6, 2, 7, 3, 4, 0]

public class Sum_Of_Subsets_NotLC {

    private static List<Integer> subsetsSum(int[] arr) {
        List<Integer> res = new ArrayList<Integer>();
        Arrays.sort(arr);
        recursive_call(arr, res, new ArrayList<>(), 0, 0);
        return res;
    }

    private static void recursive_call(int[] arr, List<Integer> res, List<Integer> list, int index, int sum) {

        if (index == arr.length) {
            res.add(sum);
            System.out.println(list.toString());
            return;
        }

        list.add(arr[index]);
        recursive_call(arr, res, list, index + 1, sum + arr[index]);
        list.remove(list.size() - 1);
        recursive_call(arr, res, list, index + 1, sum);
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 2, 4 };
        List<Integer> sums = subsetsSum(arr);

        System.out.println("Sums:" + sums.toString());
    }
}

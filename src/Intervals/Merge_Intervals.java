package Intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals {

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        res.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            // int[] prev = res.get(res.size() - 1);
            if (res.get(res.size() - 1)[1] < intervals[i][0])
                res.add(intervals[i]);
            else
                res.get(res.size() - 1)[1] = Math.max(res.get(res.size() - 1)[1], intervals[i][1]);
        }
        int[][] arr = new int[res.size()][2];
        res.toArray(arr);
        return arr;
    }
}

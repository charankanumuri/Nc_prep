package Intervals;

import java.util.Arrays;

public class Non_Overlapping_Intervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int prev = 0, erasedCount = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[prev][1] > intervals[i][0]) {
                erasedCount++;
                if (intervals[prev][1] > intervals[i][1])
                    prev = i; // choose the lowest end time interval to get min overlaps.
            } else
                prev = i;
        }
        return erasedCount;
    }
}

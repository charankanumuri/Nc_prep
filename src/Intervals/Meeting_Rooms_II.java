package Intervals;

import java.util.Arrays;

public class Meeting_Rooms_II {

    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);

        int roomsReq = 0;
        int front = 0, rear = 0;
        while (front < intervals.length) {
            if (start[front] >= end[rear]) {
                roomsReq--;
                rear++;
            }
            roomsReq++;
            front++;
        }
        return roomsReq;
    }
}

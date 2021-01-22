// https://leetcode.com/problems/non-overlapping-intervals/

import java.util.Arrays;

public class Cp0435 {
    public static void main(String args[]) {
        Cp0435 cp = new Cp0435();
        int[][] intervals = {{1,2},{2,3}, {3,4}, {1,3}};
        int result = cp.eraseOverlapIntervals(intervals);
        System.out.println(result);
    }

    // Main idea: greedy.
    // Time: O(n*log(n)).
    // Space: O(1).
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (int[] a, int[] b) -> (a[1] - b[1]));
        int result  = 0;
        int lastRight = intervals[0][1];
        for (int i=1; i<intervals.length;i++) {
            if (intervals[i][0] < lastRight) {
                result++;
            } else {
                lastRight = intervals[i][1];
            }
        }
        return result;
    }
}

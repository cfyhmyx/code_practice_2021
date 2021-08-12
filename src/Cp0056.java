// https://leetcode.com/problems/merge-intervals/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cp0056 {
    public static void main(String args[]) {
    }

    // Main idea: array.
    // Time: O(n*log(n)).
    // Space: O(1).
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> result = new ArrayList<>();
        int[] curInterval = intervals[0];
        result.add(curInterval);
        for (int[] interval : intervals) {
            if (interval[0] > curInterval[1]) {
                result.add(interval);
                curInterval = interval;
            } else {
                curInterval[1] = Math.max(curInterval[1], interval[1]);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}

// https://leetcode.com/problems/meeting-rooms/

import java.util.Arrays;

public class Cp0252 {
    public static void main(String args[]) {
    }

    // Main idea: array.
    // Time: O(n*log(n)).
    // Space: O(1).
    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }
        return true;
    }
}

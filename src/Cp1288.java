// https://leetcode.com/problems/remove-covered-intervals/

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Cp1288 {
    public static void main(String args[]) {
    }

    // Main idea: deque, sort.
    // Time: O(n*log(n)).
    // Space: O(n).
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length == 0) return 0;
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? b[0] - b[1] : a[0] - a[1]));
        int result = 0;
        Deque<Integer> dq = new LinkedList<>();
        dq.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            while (!dq.isEmpty() && intervals[i][0] >= dq.getFirst()) {
                dq.pollFirst();
                result++;
            }
            if (dq.isEmpty() || intervals[i][1] > dq.getLast()) {
                dq.addLast(intervals[i][1]);
            }
        }
        return result + dq.size();
    }

    /*public int removeCoveredIntervals(int[][] intervals) {
        int removed = 0, last = -1;
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        for (int[] i : intervals) {
            if (i[1] <= last) {
                removed += 1;
            } else {
                last = i[1];
            }
        }
        return intervals.length - removed;
    }*/
}

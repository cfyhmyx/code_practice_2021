// https://leetcode.com/problems/remove-interval/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cp1272 {
    public static void main(String args[]) {
    }

    // Main idea: array.
    // Time: O(n).
    // Space: O(1).
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> result = new ArrayList<>();
        for (int[] interval : intervals) {
            if (interval[0] >= toBeRemoved[1] || interval[1] <= toBeRemoved[0]) {
                result.add(Arrays.asList(interval[0], interval[1]));
            } else {
                if (interval[0] < toBeRemoved[0]) {
                    result.add(Arrays.asList(interval[0], toBeRemoved[0]));
                }
                if (interval[1] > toBeRemoved[1]) {
                    result.add(Arrays.asList(toBeRemoved[1], interval[1]));
                }
            }
        }
        return result;
    }
}

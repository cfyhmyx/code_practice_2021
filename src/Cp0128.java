// https://leetcode.com/problems/longest-consecutive-sequence/

import java.util.HashMap;
import java.util.Map;

public class Cp0128 {
    public static void main(String[] args) {
    }

    // Main idea: map
    // Time: O(n).
    // Space: O(n).
    public int longestConsecutive(int[] nums) {
        Map<Integer,Integer> ranges = new HashMap<>();
        int max = 0;
        for (int num : nums) {
            if (ranges.containsKey(num)) continue;
            int left = ranges.getOrDefault(num - 1, 0);
            int right = ranges.getOrDefault(num + 1, 0);
            int sum = left + right + 1;
            max = Math.max(max, sum);
            if (left > 0) ranges.put(num - left, sum);
            if (right > 0) ranges.put(num + right, sum);
            ranges.put(num, sum);
        }
        return max;
    }
}

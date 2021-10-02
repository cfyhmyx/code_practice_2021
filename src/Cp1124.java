// https://leetcode.com/problems/longest-well-performing-interval/

import java.util.HashMap;
import java.util.Map;

public class Cp1124 {
    public static void main(String args[]) {
    }

    // Main idea: map.
    // Time: O(n).
    // Space: O(n).
    public int longestWPI(int[] hours) {
        int res = 0, score = 0, n = hours.length;
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            score += hours[i] > 8 ? 1 : -1;
            if (score > 0) {
                res = i + 1;
            } else {
                seen.putIfAbsent(score, i);
                if (seen.containsKey(score - 1))
                    res = Math.max(res, i - seen.get(score - 1));
            }
        }
        return res;
    }
}

// https://leetcode.com/problems/numbers-with-same-consecutive-differences/

import java.util.HashSet;
import java.util.Set;

public class Cp0967 {
    public static void main(String args[]) {
    }

    // Main idea: dfs, backtracking.
    // Time: O(2^n).
    // Space: O(n).
    public int[] numsSameConsecDiff(int n, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= 9; i++) {
            helper(i, n, k, set, 0);
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (int num : set) {
            result[index++] = num;
        }
        return result;
    }

    private void helper(int start, int n, int k, Set<Integer> set, int cur) {
        if (n == 0) {
            set.add(cur);
            return;
        }
        if (start > 9 || start < 0) return;
        cur = cur * 10 + start;
        helper(start + k, n - 1, k, set, cur);
        helper(start - k, n - 1, k, set, cur);
    }
}

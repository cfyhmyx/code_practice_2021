// https://leetcode.com/problems/longest-repeating-substring/

public class Cp1062 {
    public static void main(String args[]) {
    }

    // Main idea: dp.
    // Time: O(n^2).
    // Space: O(n^2).
    public int longestRepeatingSubstring(String S) {
        int n = S.length();
        int[][] dp = new int[n + 1][n + 1];//dp[i][j] means # of repeated chars for substrings ending at i and j
        int res = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (S.charAt(i - 1) == S.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    res = Math.max(res, dp[i][j]);
                }
            }
        }
        return res;
    }
}

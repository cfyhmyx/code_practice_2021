// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

import java.util.Arrays;

public class Cp1312 {
    public static void main(String args[]) {
        Cp1312 cp = new Cp1312();
        int result = cp.minInsertions("leetcode");
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(m * n).
    // Space: O(m * n), can be optimized to O(min(m, n)).
    public int minInsertions(String s) {
        int lcs = lcs(s, new StringBuilder(s).reverse().toString());
        return s.length() - lcs;
    }

    private int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}

// https://leetcode.com/problems/palindrome-partitioning-iii/

import java.util.Arrays;

public class Cp1278 {
    public static void main(String args[]) {
        Cp1278 cp = new Cp1278();
        int result = cp.palindromePartition("aabb", 2);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n * n * k).
    // Space: O(n * n).
    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] count = helper(s);
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int m = 1; m <= Math.min(i, k); m++) {
                for (int j = m; j <= i; j++) {
                    dp[i][m] = Math.min(dp[i][m], dp[j - 1][m - 1] + count[j - 1][i - 1]);
                }
            }
        }
        return dp[n][k];
    }

    private int[][] helper(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = dp[i + 1][j - 1];
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] += 1;
                }
            }
        }
        return dp;
    }
}

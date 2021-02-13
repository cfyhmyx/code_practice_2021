// https://leetcode.com/problems/longest-common-subsequence/

public class Cp1143 {
    public static void main(String args[]) {
        Cp1143 cp = new Cp1143();
        int result = cp.longestCommonSubsequence("abccccccde", "ace");
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(m * n).
    // Space: O(m * n), can be optimized to O(min(m, n)).
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}

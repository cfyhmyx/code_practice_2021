// https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/

public class Cp0712 {
    public static void main(String args[]) {
        Cp0712 cp = new Cp0712();
        int result = cp.minimumDeleteSum("delete", "leet");
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(m * n).
    // Space: O(m * n), can be optimized to O(min(m, n)).
    public int minimumDeleteSum(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1) - 'a' + 97;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int sum1 = 0, sum2 = 0;
        for (char ch : s1.toCharArray()) {
            sum1 += ch - 'a' + 97;
        }
        for (char ch : s2.toCharArray()) {
            sum2 += ch - 'a' + 97;
        }
        return sum1 - dp[m][n] + sum2 - dp[m][n];
    }
}

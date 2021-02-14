// https://leetcode.com/problems/distinct-subsequences/

public class Cp0115 {
    public static void main(String args[]) {
        Cp0115 cp = new Cp0115();
        int result = cp.numDistinct("babgbag", "bag");
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(m * n).
    // Space: O(m * n).
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i<=m; i++) {
            dp[i][0] = 1;
        }
        for(int i=1; i<=m; i++) {
            for (int j=1; j<=n; j++) {
                dp[i][j] = dp[i-1][j];
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}

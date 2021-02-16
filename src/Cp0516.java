public class Cp0516 {
    public static void main(String args[]) {
        Cp0516 cp = new Cp0516();
        int result = cp.longestPalindromeSubseq("bbbab");
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n * n).
    // Space: O(n * n).
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for (int i=1; i<=n; i++) {
            dp[i][i] = 1;
        }
        for (int len= 2; len<=n;len++) {
            for(int i=1; i+len-1 <= n; i++) {
                int j = i+len-1;
                if (s.charAt(i-1) == s.charAt(j-1)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[1][n];
    }
}

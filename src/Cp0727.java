import java.util.Arrays;

public class Cp0727 {
    public static void main(String args[]) {
        Cp0727 cp = new Cp0727();
        String result = cp.minWindow("ambm", "mm");
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(m * n).
    // Space: O(m * n).
    public String minWindow(String S, String T) {
        int m = S.length();
        int n = T.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], -1);
        }
        // We only need dp[i][0] for dp[i+1][1], so set the default start position to be i.
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        int minLen = Integer.MAX_VALUE;
        int start = -1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
            if (dp[i][n] != -1) {
                int len = i - dp[i][n];
                if (minLen > len) {
                    minLen = len;
                    start = dp[i][n];
                }
            }
        }
        return (start != -1) ? S.substring(start, start + minLen) : "";
    }
}

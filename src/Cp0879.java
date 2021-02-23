// https://leetcode.com/problems/profitable-schemes/

public class Cp0879 {
    public static void main(String args[]) {
        Cp0879 cp = new Cp0879();
        int[] group = {2, 3, 5};
        int[] profit = {6, 7, 8};
        int result = cp.profitableSchemes(10, 5, group, profit);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(length * m * n).
    // Space: O(length * m * n).
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int mod = (int) 1e9 + 7;
        int[][][] dp = new int[profit.length + 1][n + 1][minProfit + 1];
        dp[0][0][0] = 1;
        for (int i = 1; i <= profit.length; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (j >= group[i-1]) {
                        dp[i][j][k] += dp[i - 1][j - group[i - 1]][Math.max(0, k - profit[i - 1])];
                        dp[i][j][k] %= mod;
                    }
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = (sum + dp[group.length][i][minProfit]) % mod;
        }
        return sum;
    }
}

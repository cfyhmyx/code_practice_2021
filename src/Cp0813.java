// https://leetcode.com/problems/largest-sum-of-averages/

public class Cp0813 {
    public static void main(String args[]) {
        Cp0813 cp = new Cp0813();
        int[] nums = {1, 2, 3};
        double result = cp.largestSumOfAverages(nums, 2);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n * n * K).
    // Space: O(n * K).
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        int[] prefix = new int[n + 1];
        int curSum = 0;
        for (int i = 0; i < n; i++) {
            curSum += A[i];
            prefix[i + 1] = curSum;
        }
        double[][] dp = new double[n + 1][K + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = -1000000;
        }
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= Math.min(i, K); k++) {
                for (int j = k; j <= i; j++) {
                    dp[i][k] = Math.max(dp[i][k], dp[j - 1][k - 1] + (prefix[i] - prefix[j - 1]) / (double) (i - j + 1));
                }
            }
        }
        return dp[n][K];
    }
}

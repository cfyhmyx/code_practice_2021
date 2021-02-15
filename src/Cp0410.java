// https://leetcode.com/problems/split-array-largest-sum/

import java.util.Arrays;

public class Cp0410 {
    public static void main(String args[]) {
        Cp0410 cp = new Cp0410();
        int[] nums = {7, 2, 8};
        double result = cp.splitArray(nums, 2);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n * n * m).
    // Space: O(n * m).
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k <= Math.min(i, m); k++) {
                int sum = 0;
                for (int j = i; j >= k; j--) {
                    sum += nums[j - 1];
                    dp[i][k] = Math.min(dp[i][k], Math.max(dp[j - 1][k - 1], sum));
                }
            }
        }
        return dp[n][m];
    }
}

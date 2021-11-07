// https://leetcode.com/problems/partition-array-for-maximum-sum/

import java.util.Arrays;

public class Cp1043 {
    public static void main(String args[]) {
        Cp1043 cp = new Cp1043();
        int[] arr = {1,4,1,5,7,3,6,1,9,9,3};
        int result = cp.maxSumAfterPartitioning(arr, 4);
        System.out.print(result);
    }

    // Main idea: dfs, memorization.
    // Time: O(k*n).
    // Space: O(n).
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        return helper(arr, dp, k, 0);
    }

    private int helper(int[] arr, int[] dp, int k, int start) {
        if (start == arr.length) {
            return 0;
        }
        if (dp[start] != -1) {
            return dp[start];
        }
        int maxSum = 0;
        int maxVal = arr[start];
        for (int i = 1; i <= k && start + i - 1 < arr.length; i++) {
            if (arr[start + i - 1] > maxVal) {
                maxVal = arr[start + i - 1];
            }
            maxSum = Math.max(maxSum, maxVal * i + helper(arr, dp, k, start + i));
        }
        dp[start] = maxSum;
        return dp[start];
    }
}

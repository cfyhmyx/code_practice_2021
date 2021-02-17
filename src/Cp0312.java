// https://leetcode.com/problems/burst-balloons/

public class Cp0312 {
    public static void main(String args[]) {
        Cp0312 cp = new Cp0312();
        int[] nums = {3, 1, 5, 8};
        int result = cp.maxCoins(nums);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n^3).
    // Space: O(n^2).
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        arr[0] = arr[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k - 1] + dp[k + 1][j] + arr[i - 1] * arr[k] * arr[j + 1]);
                }
            }
        }
        return dp[1][n];
    }

    // Main idea: divide and conquer.
    // Time: O(n^3).
    // Space: O(n^2).
    /*public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        arr[0] = arr[n + 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        return helper(1, n, arr, dp);
    }

    private int helper(int i, int j, int[] nums, int[][] dp) {
        if (i > j) return 0;
        if (dp[i][j] > 0) return dp[i][j];
        for (int x = i; x <= j; x++) {
            dp[i][j] = Math.max(dp[i][j], helper(i, x - 1, nums, dp)
                    + nums[i - 1] * nums[x] * nums[j + 1]
                    + helper(x + 1, j, nums, dp));
        }
        return dp[i][j];
    }*/
}

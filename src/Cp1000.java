// https://leetcode.com/problems/minimum-cost-to-merge-stones/

public class Cp1000 {
    public static void main(String args[]) {
        Cp1000 cp = new Cp1000();
        int[] nums = {3, 5, 1, 2, 6};
        int result = cp.mergeStones(nums, 3);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n^3).
    // Space: O(n^2).
    public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) != 0) return -1;
        int[] newStones = new int[n + 2];
        int[] prefixSum = new int[n + 2];
        int[][] dp = new int[n + 2][n + 2];
        for (int i = 1; i <= n; i++) {
            newStones[i] = stones[i - 1];
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }
        for (int len = K; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k += K - 1) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                }
                if ((j - i) % (K - 1) == 0) {
                    dp[i][j] += prefixSum[j] - prefixSum[i - 1];
                }
            }
        }
        return dp[1][n];
    }
}

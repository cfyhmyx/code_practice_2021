// https://leetcode.com/problems/length-of-longest-fibonacci-subsequence/

public class Cp0873 {
    public static void main(String args[]) {
    }

    // Main idea: dp
    // Time: O(n^2).
    // Space: O(n^2).
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int max = 0;
        int[][] dp = new int[n][n];
        for (int i = 2; i < n; i++) {
            int l = 0, r = i - 1;
            while (l < r) {
                int sum = arr[l] + arr[r];
                if (sum > arr[i]) {
                    r--;
                } else if (sum < arr[i]) {
                    l++;
                } else {
                    dp[r][i] = dp[l][r] + 1;
                    max = Math.max(max, dp[r][i]);
                    r--;
                    l++;
                }
            }
        }
        return max == 0 ? 0 : max + 2;
    }
}

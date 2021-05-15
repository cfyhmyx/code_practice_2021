// https://leetcode.com/problems/maximum-length-of-repeated-subarray/

public class Cp0718 {
    public static void main(String args[]) {
        Cp0718 cp = new Cp0718();
        int[] nums1 = {0,0,0,0,0};
        int[] nums2 = {0,0,0,0,0};
        int result = cp.findLength(nums1, nums2);
        System.out.print(result);
    }

    // Main idea: dp.
    // Time: O(n^2).
    // Space: O(n^2).
    public int findLength(int[] nums1, int[] nums2) {
        int result = 0;
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}

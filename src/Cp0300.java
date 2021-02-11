// https://leetcode.com/problems/longest-increasing-subsequence/

public class Cp0300 {
    public static void main(String args[]) {
        Cp0300 cp = new Cp0300();
        int[] nums = {0, 3, 1, 6, 2, 2, 7};
        int result = cp.lengthOfLIS(nums);
        System.out.println(result);
    }

    // Main idea: binary search.
    // Time: O(n*log(n)).
    // Space: O(n).
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;

        for (int x : nums) {
            int i = binarySearch(dp, 0, len - 1, x);
            dp[i] = x;
            if (i == len) len++;
        }

        return len;
    }

    private int binarySearch(int[] dp, int left, int right, int num) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dp[mid] == num) return mid;
            else if (dp[mid] > num) {
                right = mid - 1;
            } else if (dp[mid] < num) {
                left = mid + 1;
            }
        }
        return left;
    }
}

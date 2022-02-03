// https://leetcode.com/problems/number-of-subarrays-with-bounded-maximum/

public class Cp0795 {
    public static void main(String[] args) {
        Cp0795 cp = new Cp0795();
        int[] nums = {5, 1, 1};
        int result = cp.numSubarrayBoundedMax(nums, 2, 8);
        System.out.println(result);
    }

    // Main idea: array, dp
    // Time: O(n).
    // Space: O(1).
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0, dp = 0, start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < left) {
                res += dp;
            }
            else if (nums[i] > right) {
                dp = 0;
                start = i+1;
            }
            else if (left <= nums[i] && nums[i] <= right) {
                dp = i - start + 1;
                res += dp;
            }
        }
        return res;
    }
}

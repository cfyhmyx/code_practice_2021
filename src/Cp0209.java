// https://leetcode.com/problems/minimum-size-subarray-sum/

public class Cp0209 {
    public static void main(String args[]) {
        Cp0209 cp = new Cp0209();
        int[] nums = {2, 3, 1, 2, 4, 3};
        int result = cp.minSubArrayLen(7, nums);
        System.out.println(result);
    }

    // Main idea: slide window.
    // Time: O(n).
    // Space: O(1).
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int result = Integer.MAX_VALUE;
        int count = 0;
        while (right < nums.length) {
            count += nums[right];
            right++;
            while (count >= target) {
                result = Math.min(result, right - left);
                count -= nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}

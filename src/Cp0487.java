// https://leetcode.com/problems/max-consecutive-ones-ii/

public class Cp0487 {
    public static void main(String args[]) {
        Cp0487 cp = new Cp0487();
        int[] nums = {1, 0, 1, 0, 1};
        int result = cp.findMaxConsecutiveOnes(nums);
        System.out.println(result);
    }

    // dp_0: The max length of consecutive ones that ends with the current number, no flip.
    // dp_1: The max length of consecutive ones that ends with the current number, flipped.
    // Main idea: dp.
    // Time: O(n).
    // Space: O(1).
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length == 0) return 0;
        int dp_0 = nums[0] == 1 ? 1 : 0;
        int dp_1 = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == 0) {
                dp_1 = dp_0 + 1;
                dp_0 = 0;
            } else {
                dp_0 += 1;
                dp_1 += 1;
            }
            result = Math.max(result, dp_1);
        }
        return result;
    }
}

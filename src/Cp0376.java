// https://leetcode.com/problems/wiggle-subsequence/

public class Cp0376 {
    public static void main(String args[]) {
        Cp0376 cp = new Cp0376();
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int result = cp.wiggleMaxLength(nums);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n).
    // Space: O(1).
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 0) return 0;
        int up = 1, down = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) down = up + 1;
            else if (nums[i] > nums[i - 1]) up = down + 1;
        }
        return Math.max(up, down);
    }
}

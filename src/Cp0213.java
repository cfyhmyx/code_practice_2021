// https://leetcode.com/problems/house-robber-ii/

public class Cp0213 {
    public static void main(String args[]) {
        Cp0213 cp = new Cp0213();
        int[] nums = {0};
        int result = cp.rob(nums);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n).
    // Space: O(1).
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length <= 2) return Math.max(nums[0], nums[nums.length - 1]);
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int start, int end) {
        int notRob = 0;
        int rob = nums[start];
        for (int i = start + 1; i <= end; i++) {
            int temp = notRob;
            notRob = Math.max(notRob, rob);
            rob = temp + nums[i];
        }
        return Math.max(notRob, rob);
    }
}

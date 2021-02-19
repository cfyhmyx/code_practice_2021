// https://leetcode.com/problems/maximum-subarray/

public class Cp0053 {
    public static void main(String args[]) {
        Cp0053 cp = new Cp0053();
        int[] nums = {3, 5, 1, 2, 6};
        int result = cp.maxSubArray(nums);
        System.out.println(result);
    }

    public int maxSubArray(int[] nums) {
        int cur = nums[0];
        int result = cur;
        for (int i=1; i<nums.length; i++) {
            if (cur < 0) {
                cur = nums[i];
            } else {
                cur += nums[i];
            }
            result = Math.max(result, cur);
        }
        return result;
    }
}

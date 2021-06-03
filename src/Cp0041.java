// https://leetcode.com/problems/first-missing-positive/

public class Cp0041 {
    public static void main(String args[]) {
        Cp0041 cp = new Cp0041();
        int[] nums = {1, 1};
        int result = cp.firstMissingPositive(nums);
        System.out.print(result);
    }

    // Main idea: array, swap.
    // Time: O(n).
    // Space: O(1).
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}

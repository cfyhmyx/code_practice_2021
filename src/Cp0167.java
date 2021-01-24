// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

public class Cp0167 {
    public static void main(String args[]) {
        Cp0167 cp = new Cp0167();
        int[] nums = {1, 2, 7, 9};
        int[] result = cp.twoSum(nums, 9);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    // Main idea: two pointers.
    // Time: O(n).
    // Space: O(1).
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else if (nums[left] + nums[right] < target) {
                left++;
            } else {
                return new int[]{left + 1, right + 1};
            }
        }
        return new int[]{};
    }
}

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class Cp0153 {
    public static void main(String args[]) {
        Cp0153 cp = new Cp0153();
        int[] nums = {3, 1, 2};
        int result = cp.findMin(nums);
        System.out.println(result);
    }

    // Main idea: binary search.
    // Time: O(log(n)).
    // Space: O(1).
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}

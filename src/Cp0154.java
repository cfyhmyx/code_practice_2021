// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

public class Cp0154 {
    public static void main(String args[]) {
        Cp0154 cp = new Cp0154();
        int[] nums = {2};
        int result = cp.findMin(nums);
        System.out.println(result);
    }

    // Main idea: binary search.
    // Time: O(n).
    // Space: O(1).
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[left] && nums[mid] == nums[right]) {
                left++;
                right--;
            } else if (nums[mid] >= nums[left]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}

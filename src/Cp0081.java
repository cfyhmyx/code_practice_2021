// https://leetcode.com/problems/search-in-rotated-sorted-array-ii/

public class Cp0081 {
    public static void main(String args[]) {
        Cp0081 cp = new Cp0081();
        int[] nums = {1, 0, 1, 1, 1};
        boolean result = cp.search(nums, 0);
        System.out.println(result);
    }

    // Main idea: binary search.
    // Time: O(log(n)).
    // Space: O(1).
    public boolean search(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = (low + high) >> 1;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] == nums[low] && nums[mid] == nums[high - 1]) {
                low++;
                high--;
            } else if (nums[mid] > target) {
                if (nums[mid] >= nums[low] && nums[low] > target) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            } else {
                if (nums[mid] <= nums[high - 1] && nums[high - 1] < target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return false;
    }
}

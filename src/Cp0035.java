// https://leetcode.com/problems/search-insert-position/

public class Cp0035 {
    public static void main(String args[]) {
        Cp0035 cp = new Cp0035();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int result = cp.searchInsert(nums, 6);
        System.out.println(result);
    }

    // Main idea: binary search.
    // Time: O(log(n)).
    // Space: O(1).
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

// https://leetcode.com/problems/search-in-rotated-sorted-array/

public class Cp0033 {
    public static void main(String args[]) {
        Cp0033 cp = new Cp0033();
        int[] nums = {1};
        int result = cp.search(nums, 0);
        System.out.println(result);
    }

    // Main idea: binary search.
    // Time: O(log(n)).
    // Space: O(log(n)).
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while(low < high) {
            int mid = (low + high) >> 1;
            if(nums[mid] == target ) {
                return mid;
            } else if(nums[mid] > target) {
                if(nums[mid] >= nums[low] && nums[low] > target) {
                    low = mid+1;
                } else {
                    high = mid;
                }
            } else {
                if(nums[mid] <= nums[high-1] && nums[high-1] < target) {
                    high = mid;
                } else {
                    low = mid+1;
                }
            }
        }
        return -1;
    }
}

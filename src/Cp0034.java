// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

public class Cp0034 {
    public static void main(String args[]) {
        Cp0034 cp = new Cp0034();
        int[] nums = {5, 7, 7, 8, 8, 10};
        int[] result = cp.searchRange(nums, 6);
        for (int i : result) {
            System.out.println(i);
        }
    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target > nums[mid]) {
                left = mid + 1;
            } else if (target < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid;
                right = mid;
                break;
            }
        }
        if (left <= right) {
            while (left > 0 && nums[left] == nums[left - 1]) {
                left--;
            }
            while (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                right++;
            }
            return new int[]{left, right};
        } else {
            return new int[]{-1, -1};
        }
    }
}

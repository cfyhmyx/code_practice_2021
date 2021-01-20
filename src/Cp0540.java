// https://leetcode.com/problems/single-element-in-a-sorted-array/

public class Cp0540 {
    public static void main(String args[]) {
        Cp0540 cp = new Cp0540();
        int[] nums = {3, 3, 7, 7, 10, 10, 11};
        int result = cp.singleNonDuplicate(nums);
        System.out.println(result);
    }

    // Main idea: binary search.
    // Time: O(log(n)).
    // Space: O(1).
    public static int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) {
                mid--;
            }
            if (nums[mid] != nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 2;
            }
        }
        return nums[left];
    }

    /*public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) {
                if (nums[mid] == nums[mid - 1]) {
                    left = mid + 1;
                } else if ((mid < nums.length - 1 && nums[mid] == nums[mid + 1])) {
                    right = mid - 1;
                } else {
                    return nums[mid];
                }
            } else {
                if (mid > 0 && nums[mid] == nums[mid - 1]) {
                    right = mid - 2;
                } else if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                    left = mid + 2;
                } else {
                    return nums[mid];
                }
            }
        }
        return nums[left];
    }*/
}

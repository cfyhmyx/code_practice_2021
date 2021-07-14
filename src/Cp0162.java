// https://leetcode.com/problems/find-peak-element/

public class Cp0162 {
    public static void main(String args[]) {
    }

    // Main idea: binary search.
    // Time: O(log(n)).
    // Space: O(1).
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid1 = (low + high) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    }

    // Main idea: array.
    // Time: O(n).
    // Space: O(1).
    /*public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int i = 1;
        for (; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return i - 1;
            }
        }
        return i - 1;
    }*/
}

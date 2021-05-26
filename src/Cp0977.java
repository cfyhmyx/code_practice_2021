// https://leetcode.com/problems/squares-of-a-sorted-array/

public class Cp0977 {
    public static void main(String args[]) {

    }

    // Main idea: sort.
    // Time: O(n).
    // Space: O(1).
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int start = 0, end = nums.length - 1;
        int resIndex = nums.length - 1;
        while (start <= end) {
            if (nums[start] * nums[start] > nums[end] * nums[end]) {
                res[resIndex--] = nums[start] * nums[start];
                start++;
            } else {
                res[resIndex--] = nums[end] * nums[end];
                end--;
            }
        }
        return res;
    }
}

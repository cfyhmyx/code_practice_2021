// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

public class Cp0080 {
    public static void main(String args[]) {
    }

    // Main idea: array
    // Time: O(n).
    // Space: O(n).
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length <= 2) {
            return nums.length;
        }

        int slow = 2;
        for(int fast = 2; fast < nums.length; fast++) {
            if(nums[fast] != nums[slow-2]) {
                nums[slow++] = nums[fast];
            }
        }
        return slow;
    }
}

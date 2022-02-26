// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class Cp0026 {
    public static void main(String args[]) {
    }

    // Main idea: array
    // Time: O(n).
    // Space: O(1).
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 1) return nums.length;
        int index = 1;
        int cur = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == cur) continue;
            cur = nums[i];
            nums[index++] = cur;
        }
        return index;
    }
}

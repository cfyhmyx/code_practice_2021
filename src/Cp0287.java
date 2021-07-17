// https://leetcode.com/problems/find-the-duplicate-number/

public class Cp0287 {
    public static void main(String args[]) {
    }

    // Main idea: slow and fast pointers.
    // Time: O(n).
    // Space: O(1).
    public int findDuplicate(int[] nums) {
        if (nums.length > 1) {
            int slow = nums[0];
            int fast = nums[nums[0]];
            while (slow != fast)
            {
                slow = nums[slow];
                fast = nums[nums[fast]];
            }

            fast = 0;
            while (fast != slow)
            {
                fast = nums[fast];
                slow = nums[slow];
            }
            return slow;
        }
        return -1;
    }
}
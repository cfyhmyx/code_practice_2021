// https://leetcode.com/problems/decrease-elements-to-make-array-zigzag/

public class Cp1144 {
    public static void main(String args[]) {
    }

    // Main idea: array.
    // Time: O(n).
    // Space: O(n).
    public int movesToMakeZigzag(int[] nums) {
        int res[] = new int[2], n = nums.length, left, right;
        for (int i = 0; i < n; ++i) {
            left = i > 0 ? nums[i - 1] : 1001;
            right = i + 1 < n ? nums[i + 1] : 1001;
            res[i % 2] += Math.max(0, nums[i] - Math.min(left, right) + 1);
        }
        return Math.min(res[0], res[1]);
    }
}

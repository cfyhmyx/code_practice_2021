// https://leetcode.com/problems/jump-game-ii/

public class Cp0045 {
    public static void main(String args[]) {
    }

    // Main idea: greedy.
    // Time: O(n).
    // Space: O(1).
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, i + nums[i]);
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }
}

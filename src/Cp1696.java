// https://leetcode.com/problems/jump-game-vi/

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Cp1696 {
    public static void main(String args[]) {
        Cp1696 cp = new Cp1696();
        int[] nums = {1,-5,-20,4,-1,3,-6,-3};
        int result = cp.maxResult(nums, 2);
        System.out.print(result);
    }

    // Main idea: deque.
    // Time: O(n).
    // Space: O(n).
    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len];
        Deque<Integer> deque = new LinkedList<Integer>();
        for(int i = 0; i < len; i++) {
            int prev_max = deque.isEmpty() ? 0 : dp[deque.peekFirst()];
            dp[i] = nums[i] + prev_max;
            while(!deque.isEmpty() && dp[deque.peekLast()] < dp[i]) {
                deque.pollLast();
            }
            deque.add(i);
            while(!deque.isEmpty() && i - deque.peekFirst() >= k) {
                deque.pollFirst();
            }
        }
        return dp[len-1];
    }
}

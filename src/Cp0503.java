// https://leetcode.com/problems/next-greater-element-ii/

import java.util.Arrays;
import java.util.Stack;

public class Cp0503 {
    public static void main(String args[]) {
    }

    // Main idea: monotone stack
    // Time: O(n).
    // Space: O(n).
    public int[] nextGreaterElements(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack<>();
        int times = 2;
        while (times-- > 0) {
            for (int i = 0; i < nums.length; i++) {
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    result[stack.pop()] = nums[i];
                }
                if (result[i] == -1) {
                    stack.push(i);
                }
            }
        }
        return result;
    }
}

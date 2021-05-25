// https://leetcode.com/problems/daily-temperatures/

import java.util.Stack;

public class Cp0739 {
    public static void main(String args[]) {
    }

    // Main idea: stack.
    // Time: O(n).
    // Space: O(n).
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++) {
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int idx = stack.pop();
                ret[idx] = i - idx;
            }
            stack.push(i);
        }
        return ret;
    }
}

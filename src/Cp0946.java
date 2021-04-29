// https://leetcode.com/problems/validate-stack-sequences/

import java.util.Stack;

public class Cp0946 {
    public static void main(String args[]) {
        Cp0946 cp = new Cp0946();
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};
        boolean result = cp.validateStackSequences(pushed, popped);
        System.out.println(result);
    }

    // Main idea: stack.
    // Time: O(n).
    // Space: O(n).
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack();
        int index = 0;
        for (int num : pushed) {
            stack.push(num);
            while (index < popped.length && !stack.empty() && popped[index] == stack.peek()) {
                index++;
                stack.pop();
            }
        }
        return stack.empty();
    }
}

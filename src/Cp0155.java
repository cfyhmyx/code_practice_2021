// https://leetcode.com/problems/min-stack/

import java.util.Stack;

public class Cp0155 {
    public static void main(String args[]) {
    }

    // Main idea: stack
    // Time: O(1).
    // Space: O(n).
    class MinStack {
        int min = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<Integer>();

        public void push(int x) {
            if (x <= min) {
                stack.push(min);
                min = x;
            }
            stack.push(x);
        }

        public void pop() {
            if (stack.pop() == min) {
                min = stack.pop();
            }
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return min;
        }
    }
}

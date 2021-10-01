// https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/

import java.util.Stack;

public class Cp1130 {
    public static void main(String args[]) {
    }

    // Main idea: stack.
    // Time: O(n).
    // Space: O(n).
    public int mctFromLeafValues(int[] arr) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int a : arr) {
            while (stack.peek() <= a) {
                int mid = stack.pop();
                res += mid * Math.min(stack.peek(), a);
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            res += stack.pop() * stack.peek();
        }
        return res;
    }
}

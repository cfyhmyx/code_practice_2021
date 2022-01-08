// https://leetcode.com/problems/score-of-parentheses/

import java.util.Stack;

public class Cp0856 {
    public static void main(String args[]) {
        Cp0856 cp = new Cp0856();
        int result = cp.scoreOfParentheses("()()");
        System.out.println(result);
    }

    // Main idea: stack
    // Time: O(n).
    // Space: O(n).
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int cur = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(cur);
                cur = 0;
            } else {
                cur = stack.pop() + Math.max(cur * 2, 1);
            }
        }
        return cur;
    }

    /* public int scoreOfParentheses(String s) {
        int res = 0, l = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') l++; else l--;
            if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') res += 1 << l;
        }
        return res;
    } */
}

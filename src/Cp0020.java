// https://leetcode.com/problems/valid-parentheses/

import java.util.Stack;

public class Cp0020 {
    public static void main(String args[]) {

    }

    // Main idea: stack.
    // Time: O(n).
    // Space: O(n).
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }
}

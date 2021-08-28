// https://github.com/cfyhmyx/code_practice_2020/blob/master/src/Cp0032.java

import java.util.Stack;

public class Cp0032 {
    public static void main(String args[]) {
    }

    // Main idea: stack.
    // Time: O(n), n is the length of s.
    // Space: O(n).
    public int longestValidParentheses(String s) {
        Stack<Integer> left = new Stack<>();
        int lastRight = -1;
        int length = 0;
        for (int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                left.push(i);
            } else {
                if(left.empty()) {
                    lastRight = i;
                } else {
                    left.pop();
                    if(left.empty()) {
                        length = Math.max(length, i-lastRight);
                    } else {
                        length = Math.max(length, i-left.peek());
                    }
                }
            }
        }
        return length;
    }

}

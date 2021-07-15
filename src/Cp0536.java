// https://leetcode.com/problems/construct-binary-tree-from-string/

import java.util.Stack;

public class Cp0536 {
    public static void main(String args[]) {
    }

    // Main idea: stack.
    // Time: O(n).
    // Space: O(n).
    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = null;
        int factor = 1;
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                if (cur != null) {
                    stack.push(cur);
                }
                cur = null;
                factor = 1;
            } else if (ch == ')') {
                TreeNode temp = stack.pop();
                if (temp.left == null) {
                    temp.left = cur;
                } else {
                    temp.right = cur;
                }
                cur = temp;
            } else if (ch == '-') {
                factor = -1;
            } else {
                if (cur == null) {
                    cur = new TreeNode();
                }
                cur.val = cur.val * 10 + factor * (ch - '0');
            }
        }
        return cur;
    }
}

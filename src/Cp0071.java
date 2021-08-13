// https://leetcode.com/problems/simplify-path/

import java.util.*;

public class Cp0071 {
    public static void main(String args[]) {
        Cp0071 cp = new Cp0071();
        String result = cp.simplifyPath("/home//foo/");
        System.out.print(result);
    }

    // Main idea: stack.
    // Time: O(n).
    // Space: O(n).
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        Set<String> skip = new HashSet<>(Arrays.asList("..", ".", ""));
        for (String dir : path.split("/")) {
            if (dir.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (!skip.contains(dir)) {
                stack.push(dir);
            }
        }
        String res = "";
        while (!stack.empty()) {
            res = "/" + stack.pop() + res;
        }
        return res.isEmpty() ? "/" : res;
    }
}

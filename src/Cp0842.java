// https://leetcode.com/problems/split-array-into-fibonacci-sequence/

import java.util.ArrayList;
import java.util.List;

public class Cp0842 {
    public static void main(String args[]) {
    }

    // Main idea: dfs, backtracking
    // Time: O(10^n).
    // Space: O(n).
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> ans = new ArrayList<>();
        helper(num, ans, 0);
        return ans;
    }

    public boolean helper(String s, List<Integer> ans, int idx) {
        if (idx == s.length() && ans.size() >= 3) {
            return true;
        }
        for (int i = idx; i < s.length(); i++) {
            if (s.charAt(idx) == '0' && i > idx) {
                break;
            }
            long num = Long.parseLong(s.substring(idx, i + 1));
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = ans.size();
            if (size >= 2 && num > ans.get(size - 1) + ans.get(size - 2)) {
                break;
            }
            if (size <= 1 || num == ans.get(size - 1) + ans.get(size - 2)) {
                ans.add((int) num);
                if (helper(s, ans, i + 1)) {
                    return true;
                }
                ans.remove(ans.size() - 1);
            }
        }
        return false;
    }
}

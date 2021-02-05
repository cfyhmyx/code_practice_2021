// https://leetcode.com/problems/expression-add-operators/

import java.util.ArrayList;
import java.util.List;

public class Cp0282 {
    public static void main(String args[]) {
        Cp0282 cp = new Cp0282();
        List<String> result = cp.addOperators("123", 6);
        System.out.println(result);
    }

    // Main idea: backtracking.
    // Time: O(3^n)?
    // Space: O(n).
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        helper(res, sb, num.toCharArray(), 0, target, 0, 0);
        return res;
    }

    public void helper(List<String> res, StringBuilder sb, char[] num, int pos, int target, long prev, long multi) {
        if(pos == num.length) {
            if(target == prev) res.add(sb.toString());
            return;
        }
        long curr = 0;
        for(int i = pos; i < num.length; i++) {
            if(num[pos] == '0' && i != pos) break;
            curr = 10 * curr + num[i] - '0';
            int len = sb.length();
            if(pos == 0) {
                helper(res, sb.append(curr), num, i + 1, target, curr, curr);
                sb.setLength(len);
            } else {
                helper(res, sb.append("+").append(curr), num, i + 1, target, prev + curr, curr);
                sb.setLength(len);
                helper(res, sb.append("-").append(curr), num, i + 1, target, prev - curr, -curr);
                sb.setLength(len);
                helper(res, sb.append("*").append(curr), num, i + 1, target, prev - multi + multi * curr, multi * curr);
                sb.setLength(len);
            }
        }
    }
}

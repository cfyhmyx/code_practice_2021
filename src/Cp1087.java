// https://leetcode.com/problems/brace-expansion/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cp1087 {
    public static void main(String args[]) {
        Cp1087 cp = new Cp1087();
        String[] result = cp.expand("{a,b}c{d,e}f");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            System.out.print(" ");
        }
    }

    // Main idea: dfs, backtracking.
    // Time: O(n^m), m: number of option, n: average length of option.
    // Space: O(n).
    public String[] expand(String s) {
        List<String> list = new ArrayList<>();
        helper(s, 0, list, "");
        Collections.sort(list);
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void helper(String s, int start, List<String> list, String cur) {
        if (start == s.length()) {
            list.add(cur);
            return;
        }
        if (s.charAt(start) == '{') {
            int index = s.indexOf('}', start);
            String[] chs = s.substring(start + 1, index).split(",");
            for (String ch : chs) {
                helper(s, index + 1, list, cur + ch);
            }
        } else {
            helper(s, start + 1, list, cur + s.charAt(start));
        }
    }
}

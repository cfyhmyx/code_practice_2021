// https://leetcode.com/problems/camelcase-matching/

import java.util.ArrayList;
import java.util.List;

public class Cp1023 {
    public static void main(String args[]) {
        Cp1023 cp = new Cp1023();
        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FoBaT";
        List<Boolean> result = cp.camelMatch(queries, pattern);
        System.out.println(result);
    }

    // Main idea: two pointers.
    // Time: O(n).
    // Space: O(1).
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> result = new ArrayList<>();
        for (String query : queries) {
            result.add(helper(query, pattern));
        }
        return result;
    }

    private boolean helper(String query, String pattern) {
        if (pattern.length() > query.length()) return false;
        int i = 0;
        int j = 0;
        while (i < query.length() && j < pattern.length()) {
            Character q = query.charAt(i);
            Character p = pattern.charAt(j);
            if (p == q) {
                i++;
                j++;
                continue;
            } else if (Character.isUpperCase(q)) {
                return false;
            } else {
                i++;
            }
        }
        if (j != pattern.length()) return false;
        while (i < query.length()) {
            if (Character.isUpperCase(query.charAt(i++))) {
                return false;
            }
        }
        return true;
    }
}

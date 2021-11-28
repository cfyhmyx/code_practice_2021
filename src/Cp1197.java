// https://leetcode.com/problems/minimum-knight-moves/

import java.util.HashMap;
import java.util.Map;

public class Cp1197 {
    public static void main(String args[]) {
    }

    class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // Main idea: dfs, memorization.
    // Time: O(m*n).
    // Space: O(m*n).
    public int minKnightMoves(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Map<Pair, Integer> memo = new HashMap<Pair, Integer>();
        return helper(x, y, memo);
    }

    private int helper(int x, int y, Map<Pair, Integer> memo) {
        Pair key = new Pair(x, y);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        if (x + y == 0) {
            return 0;
        } else if (x + y == 2) {
            return 2;
        }
        int min = Math.min(helper(Math.abs(x - 1), Math.abs(y - 2), memo),
                helper(Math.abs(x - 2), Math.abs(y - 1), memo)) + 1;
        memo.put(key, min);
        return min;
    }
}

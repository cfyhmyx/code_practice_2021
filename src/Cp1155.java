// https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/

import java.util.HashMap;
import java.util.Map;

public class Cp1155 {
    public static void main(String args[]) {
        Cp1155 cp = new Cp1155();
        int result = cp.numRollsToTarget(2, 6, 7);
        System.out.print(result);
    }

    private int MOD = 1000000000 + 7;
    private int[][] map;

    // Main idea: dfs, memorization.
    // Time: O(d*f*target).
    // Space: O(d*target).
    public int numRollsToTarget(int d, int f, int target) {
        map = new int[d + 1][target + 1];
        for (int i = 0; i <= d; i++) {
            for (int j = 0; j <= target; j++) {
                map[i][j] = -1;
            }
        }
        return helper(d, f, target);
    }

    private int helper(int d, int f, int target) {
        if (d == 0 && target == 0) {
            return 1;
        }
        if (d == 0 || target == 0) {
            return 0;
        }

        if (map[d][target] != -1) {
            return map[d][target];
        }
        int res = 0;
        for (int i = 1; i <= f; i++) {
            if (target >= i) {
                res = (res + helper(d - 1, f, target - i)) % MOD;
            } else {
                break;
            }
        }
        map[d][target] = res;
        return res;
    }
}

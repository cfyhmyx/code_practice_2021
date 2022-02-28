// https://leetcode.com/problems/number-of-corner-rectangles/

import java.util.HashMap;
import java.util.Map;

public class Cp0750 {
    public static void main(String args[]) {
    }

    // Main idea: array, map
    // Time: O(m^2 * n).
    // Space: O(m^2).
    public int countCornerRectangles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m <= 1 || n <= 1) return 0;
        Map<String, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (grid[j][i] == 0) continue;
                for (int k = j + 1; k < m; k++) {
                    if (grid[k][i] == 0) continue;
                    String key = j + "&" + k;
                    int cur = map.getOrDefault(key, 0);
                    result += cur;
                    map.put(key, cur + 1);
                }
            }
        }
        return result;
    }
}

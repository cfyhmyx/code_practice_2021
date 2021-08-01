// https://leetcode.com/problems/making-a-large-island/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cp0827 {
    public static void main(String args[]) {
    }

    // Main idea: dfs, backtracking.
    // Time: O(n^2)
    // Space: O(n^2).
    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);  // Dummy value.
        int n = grid.length;
        int colorIndex = 2; // 2 is the next new color.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = paint(grid, i, j, colorIndex);
                    map.put(colorIndex, size);
                    colorIndex++;
                }
            }
        }

        int res = map.getOrDefault(2, 0);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    set.add(i > 0 ? grid[i - 1][j] : 0);
                    set.add(i < n - 1 ? grid[i + 1][j] : 0);
                    set.add(j > 0 ? grid[i][j - 1] : 0);
                    set.add(j < n - 1 ? grid[i][j + 1] : 0);

                    int newSize = 1; // The flipped cell.
                    for (int color : set) newSize += map.get(color);
                    res = Math.max(res, newSize);
                }
            }
        }
        return res;
    }

    // Backtracking to paint the area for specific color.
    private int paint(int[][] grid, int i, int j, int color) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1) return 0;
        grid[i][j] = color;
        return 1 + paint(grid, i + 1, j, color) + paint(grid, i - 1, j, color) + paint(grid, i, j + 1, color) + paint(grid, i, j - 1, color);
    }
}

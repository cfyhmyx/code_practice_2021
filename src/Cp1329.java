// https://leetcode.com/problems/sort-the-matrix-diagonally/

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Cp1329 {
    public static void main(String args[]) {
    }

    // Main idea: array, map.
    // Time: m * n * log(min(m, n)).
    // Space: O(m * n).
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                map.putIfAbsent(r - c, new PriorityQueue<>());
                map.get(r - c).add(mat[r][c]);
            }
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                mat[r][c] = map.get(r - c).poll();
            }
        }
        return mat;
    }
}

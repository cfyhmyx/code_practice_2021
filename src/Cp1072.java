// https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/

import java.util.HashMap;
import java.util.Map;

public class Cp1072 {
    public static void main(String args[]) {
        Cp1072 cp = new Cp1072();
        int[][] matrix = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        int result = cp.maxEqualRowsAfterFlips(matrix);
        System.out.print(result);
    }

    // Main idea: math, map.
    // Time: O(m*n).
    // Space: O(m*n).
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        Map<String, Integer> map = new HashMap<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            StringBuilder opposite_sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(matrix[i][j]);
                opposite_sb.append(matrix[i][j] == 0 ? 1 : 0);
            }
            String row = sb.toString();
            String reverse_row = opposite_sb.toString();
            map.put(row, map.getOrDefault(row, 0) + 1);
            if (!row.equals(reverse_row)) {
                map.put(reverse_row, map.getOrDefault(reverse_row, 0) + 1);
            }
        }
        int result = 1;
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(matrix[i][j]);
            }
            result = Math.max(result, map.get(sb.toString()));
        }
        return result;
    }
}

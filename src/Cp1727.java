// https://leetcode.com/problems/largest-submatrix-with-rearrangements/

import java.util.Arrays;

public class Cp1727 {
    public static void main(String args[]) {
        Cp1727 cp = new Cp1727();
        int[][] matrix = {{0, 0, 1}, {1, 1, 1}, {1, 0, 1}};
        int result = cp.largestSubmatrix(matrix);
        System.out.println(result);
    }

    // Main idea: greedy, sort.
    // Time: O(m*n*log(n)).
    // Space: O(1).
    public int largestSubmatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = matrix[i - 1][j] + 1;
                }
            }
        }
        int result = 0;
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            Arrays.sort(matrix[i]);
            for (int j = 1; j <= n; j++) {
                result = Math.max(result, j * matrix[i][n - j]);
            }
        }
        return result;
    }
}

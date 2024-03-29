// https://leetcode.com/problems/maximal-rectangle/

import java.util.Arrays;

public class Cp0085 {
    public static void main(String args[]) {
    }

    // Main idea: dp.
    // Time: O(m * n).
    // Space: O(m + n).
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] height = new int[n];
        Arrays.fill(right, n);
        int result = 0;
        for (int i = 0; i < m; i++) {
            int cur_left = 0;
            int cur_right = n;
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[j] = Math.max(left[j], cur_left);
                } else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }

            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1') {
                    right[j] = Math.min(right[j], cur_right);
                } else {
                    right[j] = n;
                    cur_right = j;
                }
            }

            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j] += 1;
                } else {
                    height[j] = 0;
                }
            }

            for (int j = 0; j < n; j++) {
                result = Math.max(result, (right[j] - left[j]) * height[j]);
            }
        }
        return result;
    }
}

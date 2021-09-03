// https://leetcode.com/problems/spiral-matrix-ii/

public class Cp0059 {
    public static void main(String args[]) {
    }

    // Main idea: array.
    // Time: O(n^2).
    // Space: O(1).
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int index = 1;
        while (true) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = index++;
            }
            if (++top > bottom) break;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = index++;
            }
            if (--right < left) break;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = index++;
            }
            if (--bottom < top) break;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = index++;
            }
            if (++left > right) break;
        }
        return matrix;
    }
}

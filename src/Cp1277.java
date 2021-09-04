// https://leetcode.com/problems/count-square-submatrices-with-all-ones/

public class Cp1277 {
    public static void main(String args[]) {
    }

    // Main idea: dp.
    // Time: O(m * n).
    // Space: O(1).
    public int countSquares(int[][] matrix) {
        int res = 0;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] > 0 && i > 0 && j > 0) {
                    matrix[i][j] = Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1])) + 1;
                }
                res += matrix[i][j];
            }
        }
        return res;
    }
}

// https://leetcode.com/problems/diagonal-traverse/

public class Cp0498 {
    public static void main(String args[]) {

    }

    // Main idea: array.
    // Time: O(m*n).
    // Space: O(1).
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) return new int[0];
        int r = 0, c = 0, m = matrix.length, n = matrix[0].length;
        int[] res = new int[m * n];
        for (int i = 0; i < res.length; i++) {
            res[i] = matrix[r][c];
            if ((r + c) % 2 == 0) { // moving up
                if      (c == n - 1) { r++; }
                else if (r == 0)     { c++; }
                else            { r--; c++; }
            } else {                // moving down
                if      (r == m - 1) { c++; }
                else if (c == 0)     { r++; }
                else            { r++; c--; }
            }
        }
        return res;
    }
}

// https://leetcode.com/problems/reshape-the-matrix/

public class Cp0566 {
    public static void main(String args[]) {
        Cp0566 cp = new Cp0566();
        int[][] mat = {{1, 2}, {3, 4}};
        int[][] result = cp.matrixReshape(mat, 4, 1);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]);
                System.out.print(" ");
            }
            System.out.println(" ");
        }
    }

    // Main idea: array.
    // Time: O(m*n).
    // Space: O(1).
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if (r * c != n * m) return mat;
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            res[i / c][i % c] = mat[i / n][i % n];
        }
        return res;
    }
}

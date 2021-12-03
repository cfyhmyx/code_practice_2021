// https://leetcode.com/problems/minimum-falling-path-sum/

public class Cp0931 {
    public static void main(String args[]) {
        Cp0931 cp = new Cp0931();
        int[][] matrix = {{-19, 57}, {-40, -5}};
        int result = cp.minFallingPathSum(matrix);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n^2).
    // Space: O(n).
    public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] sum = new int[n];
        for (int i = 0; i < m; i++) {
            int[] temp = sum.clone();
            for (int j = 0; j < n; j++) {
                sum[j] = matrix[i][j] + Math.min(temp[j],
                        Math.min(j > 0 ? temp[j - 1] : Integer.MAX_VALUE,
                                j < n - 1 ? temp[j + 1] : Integer.MAX_VALUE));
            }
        }
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.min(result, sum[i]);
        }
        return result;
    }
}

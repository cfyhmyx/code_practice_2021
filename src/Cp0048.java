// https://leetcode.com/problems/rotate-image/

public class Cp0048 {
    public static void main(String args[]) {
    }

    // Main idea: swap.
    // Time: O(n^2).
    // Space: O(1).
    public void rotate(int[][] matrix) {
        int s = 0, e = matrix.length - 1;
        while (s < e) {
            int[] temp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = temp;
            s++;
            e--;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}

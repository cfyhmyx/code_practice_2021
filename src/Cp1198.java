// https://leetcode.com/problems/find-smallest-common-element-in-all-rows/

import java.util.Arrays;

public class Cp1198 {
    public static void main(String args[]) {
    }

    // Main idea: binary search.
    // Time: O(m*n*log(n)).
    // Space: O(1).
    public int smallestCommonElement(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        if (m == 0) return mat[0][0];
        for (int i = 0; i < n; i++) {
            int j = 1;
            for (; j < m; j++) {
                if (Arrays.binarySearch(mat[j], mat[0][i]) < 0) break;
            }
            if (j == m) return mat[0][i];
        }
        return -1;
    }
}

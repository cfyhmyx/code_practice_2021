// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/

public class Cp0378 {
    public static void main(String args[]) {
        Cp0378 cp = new Cp0378();
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};
        int result = cp.kthSmallest(matrix, 8);
        System.out.println(result);
    }

    // Main idea: binary search.
    // Time: n*log(max-min).
    // Space: O(1).
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];
        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = 0;
            int j = 0;
            for (int i = n - 1; i >= 0; i--) {
                while (j < n && matrix[i][j] <= mid) j++;
                count += j;
            }
            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

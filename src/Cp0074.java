public class Cp0074 {
    public static void main(String args[]) {
        Cp0074 cp = new Cp0074();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        boolean result = cp.searchMatrix(matrix, 6);
        System.out.println(result);
    }

    // Main idea: binary search.
    // Time: O(log(m*n)).
    // Space: O(1).
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / n;
            int col = mid % n;
            if (matrix[row][col] > target) {
                right = mid - 1;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}

// https://leetcode.com/problems/leftmost-column-with-at-least-a-one/

import java.util.List;

public class Cp1428 {
    public static void main(String args[]) {
    }

    interface BinaryMatrix {
        public int get(int row, int col);

        public List<Integer> dimensions();
    }

    // Main idea: binary search.
    // Time: O(m*log(n)).
    // Space: O(1).
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int m = binaryMatrix.dimensions().get(0);
        int n = binaryMatrix.dimensions().get(1);
        int result = n;
        for (int i = 0; i < m; i++) {
            int left = 0;
            int right = m;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (binaryMatrix.get(i, mid) == 1) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            result = Math.min(result, left);
        }
        return result == n ? -1 : result;
    }
}

// https://leetcode.com/problems/triangle/

import java.util.List;

public class Cp0120 {
    public static void main(String[] args) {
    }

    // Main idea: array
    // Time: O(n), n is the total element.
    // Space: O(m).
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        if (m == 0) return 0;
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            result[i] = triangle.get(m - 1).get(i);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                result[j] = triangle.get(i).get(j) + Math.min(result[j], result[j + 1]);
            }
        }
        return result[0];
    }
}

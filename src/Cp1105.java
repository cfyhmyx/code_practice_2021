// https://leetcode.com/problems/filling-bookcase-shelves/

import java.util.Arrays;

public class Cp1105 {
    public static void main(String args[]) {
        Cp1105 cp = new Cp1105();
        int[][] books = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        int result = cp.minHeightShelves(books, 4);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n).
    // Space: O(n).
    public int minHeightShelves(int[][] books, int shelf_width) {
        int m = books.length;
        int dp[] = new int[m];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            int w = 0;
            int h = 0;
            for (int j = i; j>=0; j--) {
                w += books[j][0];
                if (w > shelf_width) break;
                h = Math.max(h, books[j][1]);
                dp[i] = Math.min(dp[i], (j == 0 ? 0 : dp[j - 1]) + h);
            }
        }
        return dp[m - 1];
    }
}

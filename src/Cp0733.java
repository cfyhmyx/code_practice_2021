// https://leetcode.com/problems/flood-fill/

public class Cp0733 {
    public static void main(String args[]) {
        Cp0733 cp = new Cp0733();
        int[][] image = {{0, 0, 0}, {0, 1, 1}};
        int[][] result = cp.floodFill(image, 1, 1, 1);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }
    }

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    // Main idea: dfs, backtracking.
    // Time: O(m * n).
    // Space: O(m * n).
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] != newColor) {
            helper(image, sr, sc, image.length, image[0].length, image[sr][sc], newColor);
        }
        return image;
    }

    private void helper(int[][] image, int row, int col, int m, int n, int color, int newColor) {
        if (row < 0 || row >= m || col < 0 || col >= n || image[row][col] != color) {
            return;
        }
        image[row][col] = newColor;
        for (int[] dir : dirs) {
            helper(image, row + dir[0], col + dir[1], m, n, color, newColor);
        }
    }
}

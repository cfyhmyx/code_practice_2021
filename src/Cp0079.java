// https://leetcode.com/problems/word-search/

public class Cp0079 {
    public static void main(String args[]) {
    }

    // Main idea: dfs, backtracking.
    // Time: O(n^2).
    // Space: O(n^2).
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    boolean[][] visited = new boolean[board.length][board[0].length];
                    if (helper(board, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean helper(char[][] board, String word, int row, int col, int cur, boolean[][] visited) {
        if (cur == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(cur) || visited[row][col]) {
            return false;
        }
        visited[row][col] = true;
        boolean result = helper(board, word, row + 1, col, cur + 1, visited) || helper(board, word, row - 1, col, cur + 1, visited)
                || helper(board, word, row, col + 1, cur + 1, visited) || helper(board, word, row, col - 1, cur + 1, visited);
        visited[row][col] = false;
        return result;
    }
}
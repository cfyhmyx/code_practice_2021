// https://leetcode.com/problems/snakes-and-ladders/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Cp0909 {
    public static void main(String args[]) {
        Cp0909 cp = new Cp0909();
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}};
        int result = cp.snakesAndLadders(board);
        System.out.println(result);
    }

    // Main idea: bfs
    // Time: O(n^2).
    // Space: O(n^2).
    private int n;

    public int snakesAndLadders(int[][] board) {
        n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;
        int step = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int k = 0; k < size; k++) {
                int cur = queue.poll();
                for (int i = 1; i <= 6; i++) {
                    int next = cur + i;
                    int[] pos = numToPos(next);
                    if (board[pos[0]][pos[1]] > 0) {
                        next = board[pos[0]][pos[1]];
                    }
                    if (next == n * n) {
                        return step;
                    }
                    if (!visited[next]) {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private int[] numToPos(int target) {
        int row = (target - 1) / n, col = (target - 1) % n;
        int x = n - 1 - row, y = row % 2 == 0 ? col : n - 1 - col;
        return new int[]{x, y};
    }
}

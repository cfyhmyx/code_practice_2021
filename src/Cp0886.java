// https://leetcode.com/problems/possible-bipartition/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cp0886 {
    public static void main(String args[]) {
    }

    // Main idea: graph, bfs, color
    // Time: O(V+E)
    // Space: O(V+E)
    public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0] - 1].add(dislike[1] - 1);
            graph[dislike[1] - 1].add(dislike[0] - 1);
        }
        int[] colors = new int[N];
        for (int i = 0; i < N; i++) {
            Queue<Integer> queue = new LinkedList<>();
            if (colors[i] != 0) continue;
            colors[i] = 1;
            queue.offer(i);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : graph[cur]) {
                    if (colors[next] == 0) {
                        colors[next] = -colors[cur];
                        queue.offer(next);
                    } else if (colors[next] == colors[cur]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /*public boolean possibleBipartition(int N, int[][] dislikes) {
        List<Integer>[] graph = new ArrayList[N];
        for (int i=0; i<N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] dislike : dislikes) {
            graph[dislike[0]-1].add(dislike[1]-1);
            graph[dislike[1]-1].add(dislike[0]-1);
        }
        int[] colors = new int[N];
        for (int i=0; i<N; i++) {
            if (colors[i] == 0 && !validPartition(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean validPartition(List<Integer>[] graph, int[] colors, int color, int index) {
        if (colors[index] != 0) {
            return colors[index] == color;
        }
        colors[index] = color;
        for (int next : graph[index]) {
            if (!validPartition(graph, colors, -color, next)) {
                return false;
            }
        }
        return true;
    }*/
}

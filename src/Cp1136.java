// https://leetcode.com/problems/parallel-courses/

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cp1136 {
    public static void main(String args[]) {
        Cp1136 cp = new Cp1136();
        int[][] relations = {{1,2},{2,1}};
        int result = cp.minimumSemesters(2, relations);
        System.out.print(result);
    }

    // Main idea: bfs.
    // Time: O(V+E).
    // Space: O(V+E).
    public int minimumSemesters(int n, int[][] relations) {
        int[] inDegree = new int[n+1];
        List<Integer>[] next = new List[n+1];
        for (int i=1; i<=n; i++) {
            next[i] = new LinkedList<>();
        }
        for (int[] rel : relations) {
            next[rel[0]].add(rel[1]);
            inDegree[rel[1]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                int cur = queue.poll();
                n--;
                for (int ne : next[cur]) {
                    inDegree[ne]--;
                    if (inDegree[ne] == 0) {
                        queue.offer(ne);
                    }
                }
            }
            step++;
        }
        return n == 0 ? step : -1;
    }
}

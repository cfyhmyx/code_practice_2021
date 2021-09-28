// https://leetcode.com/problems/connecting-cities-with-minimum-cost/

import java.util.Arrays;

public class Cp1135 {

    public static void main(String args[]) {
    }

    private int[] parent;
    private int n;

    // Main idea: union and find, minimum spanning tree.
    // Time: O(n*log(n)).
    // Space: O(n*log(n)).
    private boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px == py) return false;
        parent[px] = py;
        n--;
        return true;
    }

    private int find(int x) {
        if (parent[x] == x) {
            return parent[x];
        }
        parent[x] = find(parent[x]); // path compression
        return parent[x];
    }

    public int minimumCost(int N, int[][] connections) {
        parent = new int[N + 1];
        n = N;
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
        int res = 0;
        for (int[] c : connections) {
            int x = c[0], y = c[1];
            if (union(x, y)) {
                res += c[2];
            }
        }
        return n == 1 ? res : -1;
    }
}

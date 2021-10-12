// https://leetcode.com/problems/the-earliest-moment-when-everyone-become-friends/

import java.util.Arrays;

public class Cp1101 {
    public static void main(String args[]) {
    }

    private int[] root;

    // Main idea: union and find.
    // Time: O(m*log(m)).
    // Space: O(n), n is the number of people.
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs, (a, b) -> (a[0] - b[0]));
        root = new int[n];
        for (int i=0; i<n; i++) {
            root[i] = i;
        }
        for (int[] log : logs) {
            if (union(log[1], log[2])) {
                n--;
                if (n == 1) {
                    return log[0];
                }
            }
        }
        return -1;
    }

    private boolean union(int num1, int num2) {
        int root1 = find(num1);
        int root2 = find(num2);
        if (root1 == root2) return false;
        root[root2] = root1;
        return true;
    }

    private int find(int num1) {
        if (num1 == root[num1]) return num1;
        return root[num1] = find(root[num1]);
    }
}

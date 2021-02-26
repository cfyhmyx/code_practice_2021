// https://leetcode.com/problems/find-the-shortest-superstring/

import java.util.Arrays;
import java.util.LinkedList;

public class Cp0943 {
    public static void main(String args[]) {
        Cp0943 cp = new Cp0943();
        String[] words = {"catg", "ctaagt", "gcta", "ttca", "atgcatc"};
        String result = cp.shortestSuperstring(words);
        System.out.println(result);
    }

    public String shortestSuperstring(String[] words) {
        int n = words.length;
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    graph[i][j] = calDis(words[i], words[j]);
                }
            }
        }
        int m = 1 << n;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        int[][] parent = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(parent[i], -1);
        }
        for (int i = 0; i < n; i++) {
            dp[1 << i][i] = words[i].length();
        }

        for (int mask = 0; mask < m; mask++) {
            for (int bit = 0; bit < n; bit++) {
                if ((mask & (1 << bit)) == 0) continue;
                int preMask = mask ^ (1 << bit);
                for (int preBit = 0; preBit < n; preBit++) {
                    if ((preMask & (1 << preBit)) == 0) continue;
                    if (dp[mask][bit] > dp[preMask][preBit] + graph[preBit][bit]) {
                        dp[mask][bit] = dp[preMask][preBit] + graph[preBit][bit];
                        parent[mask][bit] = preBit;
                    }
                }
            }
        }

        int start = 0;
        int count = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dp[m - 1][i] < count) {
                count = dp[m - 1][i];
                start = i;
            }
        }

        int mask = m - 1;
        LinkedList<Integer> path = new LinkedList<>();
        path.addFirst(start);
        while (parent[mask][start] != -1) {
            int next = parent[mask][start];
            path.addFirst(next);
            mask = mask ^ (1 << start);
            start = next;
        }

        String result = words[path.get(0)];
        for (int i = 1; i < path.size(); i++) {
            result = combine(result, words[path.get(i)]);
        }
        return result;
    }

    private int calDis(String s, String t) {
        for (int k = Math.min(s.length(), t.length()); k >= 0; k--) {
            if (s.substring(s.length() - k).equals(t.substring(0, k))) {
                return t.length() - k;
            }
        }
        return 0;
    }

    private String combine(String s, String t) {
        for (int k = Math.min(s.length(), t.length()); k >= 0; k--) {
            if (s.substring(s.length() - k).equals(t.substring(0, k)))
                return s + t.substring(k);
        }
        return s + t;
    }
}

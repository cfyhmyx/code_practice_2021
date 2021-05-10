// https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cp1743 {
    public static void main(String args[]) {
        Cp1743 cp = new Cp1743();
        int[][] pairs = {{4, -2}, {1, 4}, {-3, 1}};
        int[] result = cp.restoreArray(pairs);
        for (int num : result) {
            System.out.println(num);
        }
    }

    // Main idea: graph.
    // Time: O(n).
    // Space: O(n).
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : adjacentPairs) {
            map.computeIfAbsent(pair[0], l -> new ArrayList<>()).add(pair[1]);
            map.computeIfAbsent(pair[1], l -> new ArrayList<>()).add(pair[0]);
        }
        int start = Integer.MAX_VALUE;
        int end = Integer.MAX_VALUE;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            if (entry.getValue().size() == 1) {
                if (start == Integer.MAX_VALUE) {
                    start = entry.getKey();
                } else {
                    end = entry.getKey();
                }
            }
        }
        int n = adjacentPairs.length + 1;
        int[] result = new int[n];
        result[0] = start;
        result[n-1] = end;
        int left = Integer.MAX_VALUE;
        for (int i = 1; i < n - 1; i++) {
            for (int j : map.get(result[i - 1])) {
                if (j != left) {
                    result[i] = j;
                    left = result[i-1];
                    break;
                }
            }
        }
        return result;
    }
}

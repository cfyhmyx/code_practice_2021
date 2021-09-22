// https://leetcode.com/problems/shortest-distance-to-target-color/

import java.util.*;

public class Cp1182 {
    public static void main(String args[]) {
    }

    // Main idea: binary search.
    // Time: O(n*log(n)).
    // Space: O(n).
    public List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < colors.length; i++) {
            if (!map.containsKey(colors[i])) {
                map.putIfAbsent(colors[i], new ArrayList<>());
            }
            map.get(colors[i]).add(i);
        }
        List<Integer> result = new ArrayList<>();
        for (int[] query : queries) {
            if (!map.containsKey(query[1])) {
                result.add(-1);
                continue;
            }
            List<Integer> list = map.get(query[1]);
            int index = Collections.binarySearch(list, query[0]);
            if (index < 0) {
                index = -(index + 1);
            }
            int before = index - 1 >= 0 ? Math.abs(query[0] - list.get(index - 1)) : Integer.MAX_VALUE;
            int cur = index < list.size() ? Math.abs(query[0]-list.get(index)) : Integer.MAX_VALUE;
            int after = index + 1 < list.size() ? Math.abs(query[0]-list.get(index+1)) : Integer.MAX_VALUE;
            result.add(Math.min(before, Math.min(cur, after)));
        }
        return result;
    }
}

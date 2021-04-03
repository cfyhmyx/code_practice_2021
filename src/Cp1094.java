// https://leetcode.com/problems/car-pooling/

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Cp1094 {
    public static void main(String args[]) {
        Cp1094 cp = new Cp1094();
        int[][] trips = {{9, 3, 4}, {9, 1, 7}, {4, 2, 4}, {7, 4, 5}};
        boolean result = cp.carPooling(trips, 23);
        System.out.println(result);
    }

    // Main idea: treemap.
    // Time: O(n*log(n)).
    // Space: O(n).
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] trip : trips) {
            map.put(trip[1], map.getOrDefault(trip[1], 0) + trip[0]);
            map.put(trip[2], map.getOrDefault(trip[2], 0) - trip[0]);
        }
        int cur = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            cur += entry.getValue();
            if (cur > capacity) {
                return false;
            }
        }
        return true;
    }

    // Main idea: array.
    // Time: O(limit).
    // Space: O(limit).
    /*public boolean carPooling(int[][] trips, int capacity) {
        int[] cache = new int[1001];
        for (int[] t : trips) {
            cache[t[1]] += t[0];
            cache[t[2]] -= t[0];
        }
        int total = 0;
        for (int num : cache) {
            total += num;
            if (total > capacity) return false;
        }
        return true;
    }*/
}

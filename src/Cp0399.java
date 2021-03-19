// https://leetcode.com/problems/evaluate-division/

import java.util.*;

public class Cp0399 {
    public static void main(String args[]) {
    }

    // Main idea: dfs.
    // Time: O(k*(V+E)), k: the number of query
    // Space: O(V+E)
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> map = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            map.computeIfAbsent(equations.get(i).get(0), m -> new HashMap<>()).put(equations.get(i).get(1), values[i]);
            map.computeIfAbsent(equations.get(i).get(1), m -> new HashMap<>()).put(equations.get(i).get(0), 1 / values[i]);
        }
        double[] result = new double[queries.size()];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < queries.size(); i++) {
            result[i] = calculate(map, queries.get(i).get(0), queries.get(i).get(1), set);
        }
        return result;
    }

    private double calculate(Map<String, Map<String, Double>> map, String a, String b, Set<String> set) {
        if (map.get(a) == null || map.get(b) == null) return -1;
        if (a.equals(b)) return 1;
        if (set.contains(a)) return -1;
        if (map.get(a).containsKey(b)) return map.get(a).get(b);
        set.add(a);
        for (String c : map.get(a).keySet()) {
            double local = calculate(map, c, b, set);
            if (local != -1) {
                map.get(a).put(b, map.get(a).get(c) * local);
                set.remove(a);
                return map.get(a).get(b);
            }
        }
        set.remove(a);
        return -1;
    }
}

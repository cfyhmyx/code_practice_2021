// https://leetcode.com/problems/time-based-key-value-store/

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Cp0981 {
    public static void main(String args[]) {
    }

    // Main idea: treemap.
    // Time: O(log(n)).
    // Space: O(n).
    class TimeMap {
        private Map<String, TreeMap<Integer, String>> map;

        /** Initialize your data structure here. */
        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            map.computeIfAbsent(key, v -> new TreeMap<>()).put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            if (!map.containsKey(key)) return "";
            Map.Entry<Integer, String> entry = map.get(key).floorEntry(timestamp);
            if (entry == null) return "";
            return entry.getValue();
        }
    }
}

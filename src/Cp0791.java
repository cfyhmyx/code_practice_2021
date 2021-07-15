// https://leetcode.com/problems/custom-sort-string/

import java.util.HashMap;
import java.util.Map;

public class Cp0791 {
    public static void main(String args[]) {
    }

    // Main idea: map.
    // Time: O(n).
    // Space: O(1).
    public String customSortString(String order, String str) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (Character ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Character ch : order.toCharArray()) {
            if (map.containsKey(ch)) {
                for (int i=0; i<map.get(ch); i++) {
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            for (int i=0; i<entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }
        return sb.toString();
    }
}

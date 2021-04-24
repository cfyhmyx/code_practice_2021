// https://leetcode.com/problems/fruit-into-baskets/

import java.util.HashMap;
import java.util.Map;

public class Cp0904 {
    public static void main(String args[]) {
    }

    // Main idea: slide window.
    // Time: O(n).
    // Space: O(1).
    public int totalFruit(int[] tree) {
        int left = 0;
        int right = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        while (right < tree.length) {
            map.put(tree[right], map.getOrDefault(tree[right], 0) + 1);
            right++;
            while (map.size() > 2) {
                map.put(tree[left], map.get(tree[left])-1);
                if (map.get(tree[left]) == 0) {
                    map.remove(tree[left]);
                }
                left++;
            }
            result = Math.max(result, right - left);
        }
        return result;
    }
}

// https://leetcode.com/problems/array-of-doubled-pairs/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Cp0954 {
    public static void main(String args[]) {
        Cp0954 cp = new Cp0954();
        int[] arr = {4, -2, 2, -4};
        boolean result = cp.canReorderDoubled(arr);
        System.out.println(result);
    }

    // Main idea: map.
    // Time: O(n*log(n)).
    // Space: O(n).
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        Arrays.sort(arr);
        for (int num : arr) {
            if (map.get(num) <= 0) {
                continue;
            } else if (num > 0 && map.getOrDefault(2 * num, 0) > 0) {
                map.put(num, map.get(num) - 1);
                map.put(2 * num, map.get(2 * num) - 1);
            } else if (num < 0 && num % 2 == 0 && map.getOrDefault(num / 2, 0) > 0) {
                map.put(num, map.get(num) - 1);
                map.put(num / 2, map.get(num / 2) - 1);
            } else if (num == 0 && map.getOrDefault(0, 0) >= 2) {
                map.put(num, map.get(num) - 2);
            } else {
                return false;
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) return false;
        }
        return true;
    }
}

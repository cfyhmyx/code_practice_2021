// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

import java.util.*;

public class Cp1296 {
    public static void main(String args[]) {
        Cp1296 cp = new Cp1296();
        int[] nums = {1, 2, 3, 3, 4, 4, 5, 6};
        boolean result = cp.isPossibleDivide(nums, 4);
        System.out.print(result);
    }

    // Main idea: greedy.
    // Time: O(n).
    // Space: O(n).
    public boolean isPossibleDivide(int[] nums, int k) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                list.add(num);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i : list) {
            int times = map.get(i);
            if (times == 0) continue;
            for (int j = 0; j < k; j++) {
                int newVal = map.getOrDefault(i + j, 0) - times;
                if (newVal < 0) {
                    return false;
                }
                map.put(i + j, newVal);
            }
        }
        return true;
    }
}

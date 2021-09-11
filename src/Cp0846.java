// https://leetcode.com/problems/hand-of-straights/

import java.util.*;

public class Cp0846 {
    public static void main(String args[]) {
    }

    // Main idea: greedy.
    // Time: O(n).
    // Space: O(n).
    public boolean isNStraightHand(int[] hand, int groupSize) {
        Arrays.sort(hand);
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : hand) {
            if (!map.containsKey(num)) {
                list.add(num);
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i : list) {
            int times = map.get(i);
            if (times == 0) continue;
            for (int j = 0; j < groupSize; j++) {
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

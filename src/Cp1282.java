// https://leetcode.com/problems/group-the-people-given-the-group-size-they-belong-to/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cp1282 {
    public static void main(String args[]) {
        Cp1282 cp = new Cp1282();
        int[] groupSizes = {2, 1, 3, 3, 3, 2};
        List<List<Integer>> result = cp.groupThePeople(groupSizes);
        System.out.print(result);
    }

    // Main idea: map, greedy.
    // Time: O(n).
    // Space: O(n).
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (!map.containsKey(groupSizes[i])) {
                map.put(groupSizes[i], new ArrayList<>());
            }
            map.get(groupSizes[i]).add(i);
            if (map.get(groupSizes[i]).size() == groupSizes[i]) {
                result.add(map.get(groupSizes[i]));
                map.remove(groupSizes[i]);
            }
        }
        return result;
    }
}

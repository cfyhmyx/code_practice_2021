// https://leetcode.com/problems/smallest-common-region/

import java.util.*;

public class Cp1257 {
    public static void main(String args[]) {
        Cp1257 cp = new Cp1257();
        List<String> list1 = Arrays.asList("Earth","North America","South America");
        List<String> list2 = Arrays.asList("North America","United States","Canada");
        List<String> list3 = Arrays.asList("United States","New York","Boston");
        List<String> list4 = Arrays.asList("Canada","Ontario","Quebec");
        List<List<String>> regions = new ArrayList<>();
        regions.add(list1);
        regions.add(list2);
        regions.add(list3);
        regions.add(list4);
        String result = cp.findSmallestRegion(regions, "Canada","Quebec");
        System.out.print(result);
    }

    // Main idea: map, set.
    // Time: O(m * n).
    // Space: O(m * n).
    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        Map<String, String> parent = new HashMap<>();

        for (List<String> region : regions) {
            if (!parent.containsKey(region.get(0))) {
                parent.put(region.get(0), region.get(0));
            }
            for (int i=1; i<region.size(); i++) {
                parent.put(region.get(i), region.get(0));
            }
        }

        Set<String> tree1 =  new HashSet<>();
        Set<String> tree2 =  new HashSet<>();
        tree1.add(region1);
        tree2.add(region2);
        while (true) {
            region1 = parent.get(region1);
            region2 = parent.get(region2);
            tree1.add(region1);
            tree2.add(region2);
            if (tree1.contains(region2)) return region2;
            if (tree2.contains(region1)) return region1;
        }
    }
}

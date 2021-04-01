// https://leetcode.com/problems/buildings-with-an-ocean-view/

import java.util.ArrayList;
import java.util.List;

public class Cp1762 {
    public static void main(String args[]) {
        Cp1762 cp = new Cp1762();
        int[] heights = {2, 2, 2, 2};
        int[] result = cp.findBuildings(heights);
        for (int res : result) {
            System.out.println(res);
        }
    }

    // Main idea: array.
    // Time: O(n).
    // Space: O(n).
    public int[] findBuildings(int[] heights) {
        List<Integer> list = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                list.add(i);
                max = heights[i];
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(list.size() - 1 - i);
        }
        return result;
    }
}

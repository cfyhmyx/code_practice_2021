// https://leetcode.com/problems/pascals-triangle/

import java.util.ArrayList;
import java.util.List;

public class Cp0118 {
    public static void main(String args[]) {
    }

    // Main idea: array
    // Time: O(n^2).
    // Space: O(1).
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
            result.add(new ArrayList<>(list));
        }
        return result;
    }
}

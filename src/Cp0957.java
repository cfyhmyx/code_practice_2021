// https://leetcode.com/problems/prison-cells-after-n-days/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Cp0957 {
    public static void main(String args[]) {
    }

    // Main idea: map, math.
    // Time: O(1).
    // Space: O(1).
    public int[] prisonAfterNDays(int[] cells, int n) {
        Map<String, Integer> seen = new HashMap<>();
        while (n > 0) {
            int[] cells2 = new int[8];
            seen.put(Arrays.toString(cells), n--);
            for (int i = 1; i < 7; ++i) {
                cells2[i] = cells[i - 1] == cells[i + 1] ? 1 : 0;
            }
            cells = cells2;
            if (seen.containsKey(Arrays.toString(cells))) {
                n %= seen.get(Arrays.toString(cells)) - n;
            }
        }
        return cells;
    }
}

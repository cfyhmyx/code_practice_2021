// https://leetcode.com/problems/gray-code/

import java.util.ArrayList;
import java.util.List;

public class Cp0089 {
    public static void main(String args[]) {
        Cp0089 cp = new Cp0089();
        List<Integer> result = cp.grayCode(2);
        System.out.print(result);
    }

    // Main idea: bit, math.
    // Time: O(1<<n).
    // Space: O(1).
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            result.add(i ^ i >> 1);
        }
        return result;
    }
}

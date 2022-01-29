// https://leetcode.com/problems/champagne-tower/

import java.util.ArrayList;
import java.util.List;

public class Cp0799 {
    public static void main(String args[]) {
        Cp0799 cp = new Cp0799();
        double result = cp.champagneTower(1, 1, 1);
        System.out.println(result);

    }

    // Main idea: dp.
    // Time: O(n^2).
    // Space: O(n).
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] cups = new double[query_row + 1];
        cups[0] = poured;
        for (int i = 0; i < query_row; i++) {
            for (int j = i; j >= 0; j--) {
                double overflow = Math.max (0, cups[j] - 1);
                if (j + 1 <= query_row) {
                    cups[j + 1] += overflow / 2;
                }
                cups[j] = overflow / 2;
            }
        }
        return cups[query_glass] >= 1 ? 1 : cups[query_glass];
    }
}

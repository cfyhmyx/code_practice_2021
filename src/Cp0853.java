// https://leetcode.com/problems/car-fleet/

import java.util.Arrays;

public class Cp0853 {
    public static void main(String args[]) {
    }

    // Main idea: math, sort.
    // Time: O(nlog(n)).
    // Space: O(n).
    public int carFleet(int target, int[] position, int[] speed) {
        int n = position.length, res = 0;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; ++i)
            cars[i] = new double[] {position[i], (double)(target - position[i]) / speed[i]};
        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        double cur = 0;
        for (int i = n - 1; i >= 0 ; --i) {
            if (cars[i][1] > cur) {
                cur = cars[i][1];
                res++;
            }
        }
        return res;
    }
}

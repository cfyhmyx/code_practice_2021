// https://leetcode.com/problems/maximum-building-height/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Cp1840 {
    public static void main(String args[]) {
        Cp1840 cp = new Cp1840();
        int[][] res = {};
        int result = cp.maxBuilding(6, res);
        System.out.println(result);
    }

    // Main idea: array.
    // Time: O(n*log(n)).
    // Space: O(1).
    public int maxBuilding(int n, int[][] restrictions) {
        Arrays.sort(restrictions, (a, b) -> Integer.compare(a[0], b[0]));

        int prevId = 1, prevH = 0, lastH = n - 1;
        for (int[] restriction : restrictions) {
            restriction[1] = Math.min(restriction[1], prevH + restriction[0] - prevId);
            prevId = restriction[0];
            prevH = restriction[1];
        }
        lastH = Math.min(lastH, prevH + n - prevId);

        for (int i = restrictions.length - 2; i >= 0; i--) {
            restrictions[i][1] = Math.min(restrictions[i][1], restrictions[i + 1][1] + restrictions[i + 1][0] - restrictions[i][0]);
        }

        int l = 1, h1 = 0, ans = 0;
        for (int[] restriction : restrictions) {
            ans = Math.max(ans, Math.max(h1, restriction[1]) + (restriction[0] - l - Math.abs(restriction[1] - h1)) / 2);

            l = restriction[0];
            h1 = restriction[1];
        }

        ans = Math.max(ans, Math.max(h1, lastH) + (n - l - Math.abs(lastH - h1)) / 2);

        return ans;
    }

    /*public int maxBuilding(int n, int[][] restrictions) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] re : restrictions) {
            map.put(re[0], re[1]);
        }
        int[] height = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            height[i] = Math.min(height[i - 1] + 1, map.getOrDefault(i, 10000));
        }
        int result = height[n];
        for (int i = n - 1; i >= 2; i--) {
            height[i] = Math.min(height[i + 1] + 1, height[i]);
            result = Math.max(result, height[i]);
        }
        return result;
    }*/
}

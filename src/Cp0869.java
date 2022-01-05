// https://leetcode.com/problems/reordered-power-of-2/

import java.util.Arrays;

public class Cp0869 {
    public static void main(String args[]) {
        Cp0869 cp = new Cp0869();
        boolean result = cp.reorderedPowerOf2(64);
        System.out.println(result);
    }

    // Main idea: map
    // Time: O(1).
    // Space: O(1).
    public boolean reorderedPowerOf2(int n) {
        int[] freqN = count(n);
        for (int i = 0; i < 32; i++)
            if (Arrays.equals(freqN, count(1 << i))) {
                return true;
            }
        return false;
    }

    private int[] count(int n) {
        int[] ans = new int[10];
        while (n > 0) {
            ans[n % 10]++;
            n /= 10;
        }
        return ans;
    }
}
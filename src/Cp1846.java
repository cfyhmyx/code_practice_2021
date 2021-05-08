// https://leetcode.com/contest/biweekly-contest-51

import java.util.Arrays;

public class Cp1846 {
    public static void main(String args[]) {
    }

    // Main idea: array.
    // Time: init: O(n*log(n)).
    // Space: O(1).
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i-1] > 1) {
                arr[i] = arr[i-1]+1;
            }
        }
        return arr[arr.length-1];
    }
}

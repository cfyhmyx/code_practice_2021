// https://leetcode.com/problems/unique-binary-search-trees/

public class Cp0096 {
    public static void main(String args[]) {
    }

    // Main idea: dp.
    // Time: O(n^2).
    // Space: O(n).
    public int numTrees(int n) {
        if (n <= 1) return 1;
        int[] arr = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;
        int index = 2;
        while (index <= n) {
            for (int i = 0; i < index; i++) {
                arr[index] += arr[i] * arr[index - 1 - i];
            }
            index++;
        }
        return arr[n];
    }
}

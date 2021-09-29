// https://leetcode.com/problems/maximum-of-absolute-value-expression/

public class Cp1131 {
    public static void main(String args[]) {
    }

    // Main idea: math.
    // Time: O(n).
    // Space: O(n).
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int res = 0, n = arr1.length, P[] = {-1, 1};
        for (int p : P) {
            for (int q : P) {
                int smallest = p * arr1[0] + q * arr2[0] + 0;
                for (int i = 1; i < n; ++i) {
                    int cur = p * arr1[i] + q * arr2[i] + i;
                    res = Math.max(res, cur - smallest);
                    smallest = Math.min(smallest, cur);
                }
            }
        }
        return res;
    }
}

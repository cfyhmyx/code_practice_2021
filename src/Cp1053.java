// https://leetcode.com/problems/previous-permutation-with-one-swap/

public class Cp1053 {
    public static void main(String args[]) {
    }

    // Main idea: math.
    // Time: O(n).
    // Space: O(1).
    public int[] prevPermOpt1(int[] arr) {
        if (arr.length <= 1) return arr;
        int idx = -1;
        // find the largest i such that A[i] > A[i + 1]
        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i] < arr[i - 1]) {
                idx = i - 1;
                break;
            }
        }
        // the array already sorted, not smaller permutation
        if (idx == -1) return arr;
        // find the largest j such that A[j] > A[i], then swap them
        for (int i = arr.length - 1; i > idx; i--) {
            // the second check to skip duplicate numbers
            if (arr[i] < arr[idx] && arr[i] != arr[i - 1]) {
                int tmp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = tmp;
                break;
            }
        }
        return arr;
    }
}

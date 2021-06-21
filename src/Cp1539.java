// https://leetcode.com/problems/kth-missing-positive-number/

public class Cp1539 {
    public static void main(String args[]) {
    }

    // Main idea: binary search.
    // Time: O(log(n)).
    // Space: O(1).
    public int findKthPositive(int[] arr, int k) {
        int l = 0, r = arr.length, m;
        while (l < r) {
            m = (l + r) / 2;
            if (arr[m] - 1 - m < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        // From A[0] to A[L-1], we have A[L-1]-L nums missing,
        // we need to miss k-(A[L-1]-L) after A[L-1],
        // so it is A[L-1]+k-(A[L-1]-L)=k+L.
        return l + k;
    }
}

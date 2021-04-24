// https://leetcode.com/problems/binary-subarrays-with-sum/

public class Cp0930 {
    public static void main(String args[]) {
        Cp0930 cp = new Cp0930();
        int[] A = {1, 0, 1, 0, 1};
        int result = cp.numSubarraysWithSum(A, 2);
        System.out.println(result);
    }

    // Main idea: slide window.
    // Time: O(n).
    // Space: O(1).
    public int numSubarraysWithSum(int[] A, int S) {
        return AtMost(A, S) - AtMost(A, S - 1);
    }

    public int AtMost(int[] A, int S) {
        if (S < 0) return 0;
        int left = 0;
        int right = 0;
        int result = 0;
        while (right < A.length) {
            if (A[right] == 1) {
                S--;
            }
            right++;
            while (S < 0) {
                if (A[left] == 1) {
                    S++;
                }
                left++;
            }
            result += right - left;
        }
        return result;
    }
}

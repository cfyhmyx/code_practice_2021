// https://leetcode.com/problems/max-consecutive-ones-iii/

public class Cp1004 {
    public static void main(String args[]) {
        Cp1004 cp = new Cp1004();
        int[] A = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int result = cp.longestOnes(A, 3);
        System.out.println(result);
    }

    // Main idea: slide window.
    // Time: O(n).
    // Space: O(1).
    public int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;
        int result = 0;
        int count = K;
        while (right < A.length) {
            if (A[right] == 0) {
                count--;
            }
            right++;
            while (count < 0) {
                if (A[left] == 0) {
                    count++;
                }
                left++;
            }
            result = Math.max(result, right - left);
        }
        return result;
    }
}

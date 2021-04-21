// https://leetcode.com/problems/subarrays-with-k-different-integers/

import java.util.HashMap;
import java.util.Map;

public class Cp0992 {
    public static void main(String args[]) {
    }

    // Main idea: slide window.
    // Time: O(n).
    // Space: O(n).
    public int subarraysWithKDistinct(int[] A, int K) {
        return atMostK(A, K) - atMostK(A, K-1);
    }

    private int atMostK(int[] A, int k) {
        int left = 0;
        int right = 0;
        Map<Integer, Integer> count = new HashMap<>();
        int result = 0;
        while (right < A.length) {
            if (count.getOrDefault(A[right], 0) == 0) {
                k--;
            }
            count.put(A[right], count.getOrDefault(A[right], 0) + 1);
            right++;
            while (k < 0) {
                count.put(A[left], count.get(A[left]) - 1);
                if (count.get(A[left]) == 0) {
                    k++;
                }
                left++;
            }
            result += right - left;
        }
        return result;
    }
}

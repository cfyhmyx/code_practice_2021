// https://leetcode.com/problems/random-pick-with-weight/

import java.util.Random;

public class Cp0528 {
    public static void main(String args[]) {
    }

    // Main idea: prefix sum, binary search.
    // Time: init: O(n), pick: O(log(n)).
    // Space: O(n).
    class Solution {
        Random random;
        int[] sum;

        public Solution(int[] w) {
            this.random = new Random();
            sum = new int[w.length];
            sum[0] = w[0];
            for (int i = 1; i < sum.length; ++i)
                sum[i] = w[i] + sum[i - 1];
        }

        public int pickIndex() {
            int idx = random.nextInt(sum[sum.length - 1]) + 1;
            int left = 0, right = sum.length - 1;
            // search position
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (sum[mid] == idx) {
                    return mid;
                } else if (sum[mid] < idx) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            return left;
        }
    }
}

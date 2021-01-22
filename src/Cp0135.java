// https://leetcode.com/problems/candy/

import java.util.Arrays;

public class Cp0135 {
    public static void main(String args[]) {
        Cp0135 cp = new Cp0135();
        int[] ratings = {1, 2, 4, 3, 2, 1, 2};
        int result = cp.candy(ratings);
        System.out.println(result);
    }

    // Main idea: greedy.
    // Time: O(n).
    // Space: O(1).
    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
        int n = ratings.length;
        int i = 0;
        // The next start point.
        int s = 0;
        // Will minus 1 every round.
        int sum = 1;
         while (i < n - 1) {
            while (i < n - 1 && ratings[i + 1] > ratings[i]) {
                i++;
            }
            int left = i - s;
            s = i;
            while (i < n - 1 && ratings[i + 1] < ratings[i]) {
                i++;
            }
            int right = i - s;
            int max = Math.max(left, right) + 1;
            sum += (1 + left) * left / 2 + (1 + right) * right / 2 + max - 1;
            while (i < n - 1 && ratings[i + 1] == ratings[i]) {
                i++;
                sum++;
            }
            s = i;
        }
        return sum;
    }

    // Main idea: greedy.
    // Time: O(n).
    // Space: O(n).
    /*public int candy(int[] ratings) {
        int n = ratings.length;
        int[] result = new int[n];
        Arrays.fill(result, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                result[i] = result[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                result[i] = Math.max(result[i + 1] + 1, result[i]);
            }
        }
        int sum = 0;
        for (int res : result) {
            sum += res;
        }
        return sum;
    }*/
}

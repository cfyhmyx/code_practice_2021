// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/#/description

import java.util.Arrays;

public class Cp0188 {
    public static void main(String args[]) {
        Cp0188 cp = new Cp0188();
        int[] nums = {3,3,5,0,0,3,1,4};
        int result = cp.maxProfit(2, nums);
        System.out.println(result);
    }

    //T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
    //T[i][k][1] = max(T[i-1][k][1], T[i-1][k-1][0] - prices[i])
    // Main idea: dp.
    // Time: O(n*k).
    // Space: O(k).
    public int maxProfit(int k, int[] prices) {
        if (k >= prices.length >>> 1) {
            int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

            for (int price : prices) {
                int T_ik0_old = T_ik0;
                T_ik0 = Math.max(T_ik0, T_ik1 + price);
                T_ik1 = Math.max(T_ik1, T_ik0_old - price);
            }

            return T_ik0;
        }

        int[] T_ik0 = new int[k + 1];
        int[] T_ik1 = new int[k + 1];
        Arrays.fill(T_ik1, Integer.MIN_VALUE);

        for (int price : prices) {
            for (int j = k; j > 0; j--) {
                T_ik0[j] = Math.max(T_ik0[j], T_ik1[j] + price);
                T_ik1[j] = Math.max(T_ik1[j], T_ik0[j - 1] - price);
            }
        }

        return T_ik0[k];
    }
}

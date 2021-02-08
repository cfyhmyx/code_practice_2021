// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/

public class Cp0714 {
    public static void main(String args[]) {
        Cp0714 cp = new Cp0714();
        int[] nums = {1, 3, 2, 8, 4, 9};
        int result = cp.maxProfit(nums, 2);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n).
    // Space: O(1).
    public int maxProfit(int[] prices, int fee) {
        int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;
        for (int price : prices) {
            int old_T_ik0 = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, old_T_ik0 - price - fee);
        }
        return T_ik0;
    }
}

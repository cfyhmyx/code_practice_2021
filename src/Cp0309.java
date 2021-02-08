// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/#/description

public class Cp0309 {
    public static void main(String args[]) {
        Cp0309 cp = new Cp0309();
        int[] nums = {3,3,5,0,0,3,1,4};
        int result = cp.maxProfit(nums);
        System.out.println(result);
    }

    // T[i][k][0] = max(T[i-1][k][0], T[i-1][k][1] + prices[i])
    // T[i][k][1] = max(T[i-1][k][1], T[i-2][k][0] - prices[i])
    // Main idea: dp.
    // Time: O(n).
    // Space: O(1).
    public int maxProfit(int[] prices) {
        int T_ik0_pre = 0, T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_pre - price);
            T_ik0_pre = T_ik0_old;
        }

        return T_ik0;
    }
}

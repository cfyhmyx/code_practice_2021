// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/

public class Cp0123 {
    public static void main(String args[]) {
        Cp0123 cp = new Cp0123();
        int[] nums = {3,3,5,0,0,3,1,4};
        int result = cp.maxProfit(nums);
        System.out.println(result);
    }

    //T[i][2][0] = max(T[i-1][2][0], T[i-1][2][1] + prices[i])
    //T[i][2][1] = max(T[i-1][2][1], T[i-1][1][0] - prices[i])
    //T[i][1][0] = max(T[i-1][1][0], T[i-1][1][1] + prices[i])
    //T[i][1][1] = max(T[i-1][1][1], -prices[i])
    // Main idea: dp.
    // Time: O(n).
    // Space: O(1).
    public int maxProfit(int[] prices) {
        int T_i10 = 0, T_i11 = Integer.MIN_VALUE;
        int T_i20 = 0, T_i21 = Integer.MIN_VALUE;

        for (int price : prices) {
            T_i20 = Math.max(T_i20, T_i21 + price);
            T_i21 = Math.max(T_i21, T_i10 - price);
            T_i10 = Math.max(T_i10, T_i11 + price);
            T_i11 = Math.max(T_i11, -price);
        }

        return T_i20;
    }
}

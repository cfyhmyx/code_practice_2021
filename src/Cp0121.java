// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class Cp0121 {
    public static void main(String args[]) {
        Cp0121 cp = new Cp0121();
        int[] nums = {3,3,5,0,0,3,1,4};
        int result = cp.maxProfit(nums);
        System.out.println(result);
    }

    // Main idea: dp.
    // Time: O(n).
    // Space: O(1).
    public int maxProfit(int[] prices) {
        int Ti10 = 0, Ti11 = Integer.MIN_VALUE;
        for (int price : prices) {
            Ti10 = Math.max(Ti10, Ti11 + price);
            Ti11 = Math.max(Ti11, -price);
        }
        return Ti10;
    }
}

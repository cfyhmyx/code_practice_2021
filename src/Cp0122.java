// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

public class Cp0122 {
    public static void main(String args[]) {
        Cp0122 cp = new Cp0122();
        int[] nums = {3,3,5,0,0,3,1,4};
        int result = cp.maxProfit(nums);
        System.out.println(result);
    }

    public int maxProfit(int[] prices) {
        int T_ik0 = 0, T_ik1 = Integer.MIN_VALUE;

        for (int price : prices) {
            int T_ik0_old = T_ik0;
            T_ik0 = Math.max(T_ik0, T_ik1 + price);
            T_ik1 = Math.max(T_ik1, T_ik0_old - price);
        }

        return T_ik0;
    }
}

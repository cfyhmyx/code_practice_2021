// https://leetcode.com/problems/climbing-stairs/

public class Cp0070 {
    public static void main(String args[]) {
        Cp0070 cp = new Cp0070();
        int result = cp.climbStairs(10);
        System.out.println(result);
    }

    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int pre = 1;
        int cur = 2;
        for (int i = 3; i <= n; i++) {
            int temp = cur;
            cur = pre + cur;
            pre = temp;
        }
        return cur;
    }
}

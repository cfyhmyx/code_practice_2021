// https://leetcode.com/problems/powx-n/

public class Cp0050 {
    public static void main(String args[]) {
        Cp0050 cp = new Cp0050();
        double result = cp.myPow(1.00000,
                Integer.MIN_VALUE);
        System.out.println(result);
    }

    // Main idea: binary search.
    // Time: O(log(n)).
    // Space: O(log(n)).
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / helper(x, n);
        } else {
            return helper(x, n);
        }
    }

    public double helper(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double temp = helper(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            return temp * temp * x;
        }
    }
}

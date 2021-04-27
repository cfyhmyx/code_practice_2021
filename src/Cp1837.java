// https://leetcode.com/problems/sum-of-digits-in-base-k/

public class Cp1837 {
    public static void main(String args[]) {
        Cp1837 cp = new Cp1837();
        int result = cp.sumBase(34, 6);
        System.out.println(result);
    }

    // Main idea: math.
    // Time: O(log(n)).
    // Space: O(1).
    public int sumBase(int n, int k) {
        int sum = 0;
        while (n > 0) {
            sum += n % k;
            n /= k;
        }
        return sum;
    }
}

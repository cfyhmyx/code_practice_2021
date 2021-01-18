// https://leetcode.com/problems/super-pow/

public class Cp0372 {
    public static void main(String args[]) {
        Cp0372 cp = new Cp0372();
        int result = cp.superPow(2,
                new int[]{1, 0});
        System.out.println(result);
    }

    // Main idea: math.
    // Time: O(n).
    // Space: O(n).
    public int superPow(int a, int[] b) {
        return superPow(a, b, b.length, 1337);
    }

    private int superPow(int a, int[] b, int length, int k) {
        if(length == 0) return 1;
        return cal(superPow(a, b, length - 1, k), 10, k) * cal(a, b[length - 1], k) % k;
    }

    private int cal(int x, int power, int k) {
        x %= k;
        int pow = 1;
        for (int i = 0; i < power; i++) {
            pow = (pow * x) % k;
        }
        return pow;
    }
}

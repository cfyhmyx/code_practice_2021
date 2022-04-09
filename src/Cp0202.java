// https://leetcode.com/problems/happy-number/

import java.util.HashSet;
import java.util.Set;

public class Cp0202 {
    public static void main(String args[]) {
    }

    // Main idea: hashset
    // Time: O(?).
    // Space: O(n).
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            int squareSum = 0;
            while (n > 0) {
                int remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }
            if (squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }
        }
        return false;
    }

}

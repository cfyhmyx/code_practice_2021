// https://leetcode.com/problems/palindrome-number/

public class Cp0009 {
    public static void main(String args[]) {
    }

    // Main idea: math.
    // Time: O(n).
    // Space: O(1).
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }

}

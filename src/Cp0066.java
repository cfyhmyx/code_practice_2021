// https://leetcode.com/problems/plus-one/

public class Cp0066 {
    public static void main(String[] args) {
    }

    // Main idea: math
    // Time: O(n).
    // Space: O(1).
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i=n-1; i>=0; i--) {
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] newNumber = new int [n+1];
        newNumber[0] = 1;
        return newNumber;
    }
}

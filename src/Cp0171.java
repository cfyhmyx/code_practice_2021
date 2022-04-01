// https://leetcode.com/problems/excel-sheet-column-number/

public class Cp0171 {
    public static void main(String args[]) {
    }

    // Main idea: math
    // Time: O(n).
    // Space: O(1).
    public int titleToNumber(String columnTitle) {
        int result = 0;
        for (int i = 0; i < columnTitle.length(); i++) {
            int add = columnTitle.charAt(i) - 'A' + 1;
            result = result * 26 + add;
        }
        return result;
    }
}

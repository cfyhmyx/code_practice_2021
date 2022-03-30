// https://leetcode.com/problems/excel-sheet-column-title/

public class Cp0168 {
    public static void main(String args[]) {
    }

    // Main idea: math
    // Time: O(1).
    // Space: O(1).
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n--;
            int offset = n % 26;
            char add = (char) ('A' + offset);
            result.insert(0, add);
            n = n / 26;
        }
        return result.toString();
    }

}

// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/

public class Cp0921 {
    public static void main(String args[]) {
        Cp0921 cp = new Cp0921();
        int result = cp.minAddToMakeValid("()))((");
        System.out.println(result);
    }

    // Main idea: straightforward.
    // Time: O(n).
    // Space: O(1).
    public int minAddToMakeValid(String S) {
        int leftBracket = 0;
        int result = 0;
        for (Character ch : S.toCharArray()) {
            if (ch == '(') {
                leftBracket++;
            } else {
                if (leftBracket == 0) {
                    result++;
                } else {
                    leftBracket--;
                }
            }
        }
        return result + leftBracket;
    }
}

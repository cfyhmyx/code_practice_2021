// https://leetcode.com/problems/add-binary/

public class Cp0067 {
    public static void main(String args[]) {
    }

    // Main idea: string
    // Time: O(n).
    // Space: O(1).
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        for(int i=a.length()-1, j=b.length()-1; i>=0||j>=0; i--,j--) {
            int num1 = i>=0 ? a.charAt(i)-'0' : 0;
            int num2 = j>=0 ? b.charAt(j)-'0' : 0;
            int sum = num1 + num2 + carry;
            result.append(sum%2);
            carry = sum/2;
        }
        if(carry == 1) {
            result.append(1);
        }
        return result.reverse().toString();
    }
}

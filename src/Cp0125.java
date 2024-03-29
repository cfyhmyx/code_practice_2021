// https://leetcode.com/problems/valid-palindrome/

public class Cp0125 {
    public static void main(String args[]) {
        Cp0125 cp = new Cp0125();
        String s = "0o";
        boolean result = isPalindrome(s);
        System.out.println(result);
    }

    // Main idea: two pointers.
    // Time: O(n).
    // Space: O(1).
    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if(!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }
}

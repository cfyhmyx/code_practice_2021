// https://leetcode.com/problems/length-of-last-word/

public class Cp0058 {
    public static void main(String args[]) {
    }

    // Main idea: string
    // Time: O(n).
    // Space: O(n).
    public int lengthOfLastWord(String s) {
        if(s==null ||s.length() == 0) return 0;
        int result = 0;
        char[] arr = s.toCharArray();
        int i=s.length()-1;
        for(; i>=0; i--) {
            if(arr[i] != ' ') {
                break;
            }
        }
        while(i>=0 && arr[i]!= ' ') {
            result++;
            i--;
        }
        return result;
    }
}

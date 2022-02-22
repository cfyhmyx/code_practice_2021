// https://leetcode.com/problems/count-and-say/

public class Cp0038 {
    public static void main(String[] args) {
    }

    // Main idea: math
    // Time: O(?).
    // Space: O(1).
    public String countAndSay(int n) {
        if (n < 1) return "";
        String result = "1";
        while (n - 1 > 0) {
            StringBuilder next = new StringBuilder();
            char cur = result.charAt(0);
            int count = 1;
            for (int i = 1; i < result.length(); i++) {
                if (result.charAt(i) == cur) {
                    count++;
                } else {
                    next.append(count).append(cur);
                    cur = result.charAt(i);
                    count = 1;
                }
            }
            next.append(count).append(cur);
            result = next.toString();
            n--;
        }
        return result;
    }
}

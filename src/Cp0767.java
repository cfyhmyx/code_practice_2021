// https://leetcode.com/problems/reorganize-string/

public class Cp0767 {
    public static void main(String[] args) {
        Cp0767 cp = new Cp0767();
        String result = cp.reorganizeString("aaab");
        System.out.println(result);
    }

    // Main idea: array
    // Time: O(n).
    // Space: O(1).
    public String reorganizeString(String s) {
        int[] hash = new int[26];
        int max = 0, letter = 0;
        for (int i = 0; i < s.length(); i++) {
            int curLetter = s.charAt(i) - 'a';
            hash[curLetter]++;
            if (hash[curLetter] > max) {
                max = hash[curLetter];
                letter = s.charAt(i) - 'a';
            }
        }
        if (max > (s.length() + 1) / 2) {
            return "";
        }
        char[] res = new char[s.length()];
        int idx = 0;
        while (hash[letter] > 0) {
            res[idx] = (char) (letter + 'a');
            idx += 2;
            hash[letter]--;
        }
        for (int i = 0; i < hash.length; i++) {
            while (hash[i] > 0) {
                if (idx >= res.length) {
                    idx = 1;
                }
                res[idx] = (char) (i + 'a');
                idx += 2;
                hash[i]--;
            }
        }
        return String.valueOf(res);
    }
}

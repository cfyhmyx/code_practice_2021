// https://leetcode.com/problems/short-encoding-of-words/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Cp0820 {
    public static void main(String args[]) {
    }

    // Main idea: set.
    // Time: O(nlog(n) + n*C), C is the average length of word.
    // Space: O(n*C).
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, (a, b)->(b.length() - a.length()));
        Set<String> set = new HashSet<>();
        int result = 0;
        for (int i=0; i<words.length; i++) {
            if (!set.contains(words[i])) {
                for (int j = 0; j<words[i].length(); j++) {
                    set.add(words[i].substring(j));
                }
                result += words[i].length() + 1;
            }
        }
        return result;
    }
}

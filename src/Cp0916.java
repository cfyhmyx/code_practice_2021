// https://leetcode.com/problems/word-subsets/

import java.util.ArrayList;
import java.util.List;

public class Cp0916 {
    public static void main(String args[]) {
    }

    // Main idea: map
    // Time: O(Math.max(word1.length * avg1, words2.length * avg2) for insert.
    // Space: O(1).
    public List<String> wordSubsets(String[] words1, String[] words2) {
        int[] map2 = new int[26];
        for (String word : words2) {
            int[] localMap = new int[26];
            for (Character ch : word.toCharArray()) {
                localMap[ch - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                map2[i] = Math.max(map2[i], localMap[i]);
            }
        }
        List<String> result = new ArrayList<>();
        for (String word : words1) {
            int[] localMap = new int[26];
            for (Character ch : word.toCharArray()) {
                localMap[ch - 'a']++;
            }
            int i = 0;
            for (; i < 26; i++) {
                if (map2[i] > localMap[i]) {
                    break;
                }
            }
            if (i == 26) {
                result.add(word);
            }
        }
        return result;
    }
}

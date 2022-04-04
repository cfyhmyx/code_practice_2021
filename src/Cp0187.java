// https://leetcode.com/problems/repeated-dna-sequences/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Cp0187 {
    public static void main(String args[]) {
    }

    // Main idea: hashset
    // Time: O(n).
    // Space: O(n).
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();
        for(int i=0; i<=s.length()-10; i++) {
            String cur = s.substring(i, i+10);
            if(!seen.add(cur)) {
                repeated.add(cur);
            }
        }
        return new ArrayList<>(repeated);
    }
}

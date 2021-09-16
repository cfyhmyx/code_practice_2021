// https://leetcode.com/problems/iterator-for-combination/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cp1286 {
    public static void main(String args[]) {
    }

    // Main idea: dfs, backtracking.
    // Time: O(n!) for constructor, O(1) for other methods.
    // Space: O(C(len)(combinationLength)).
    class CombinationIterator {
        private List<String> list;
        private int index = 0;

        public CombinationIterator(String characters, int combinationLength) {
            list = new ArrayList<>();
            Collections.sort(list);
            helper(characters, "", combinationLength, 0);
        }

        private void helper(String str, String cur, int len, int start) {
            if (len == 0) {
                list.add(cur);
                return;
            }
            for (int i=start; i <= str.length()-len; i++) {
                helper(str, cur+str.charAt(i), len-1, i+1);
            }
        }

        public String next() {
            return list.get(index++);
        }

        public boolean hasNext() {
            return index < list.size();
        }
    }
}

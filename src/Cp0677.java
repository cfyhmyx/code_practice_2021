// https://leetcode.com/problems/map-sum-pairs/

import java.util.ArrayList;
import java.util.List;

public class Cp0677 {
    public static void main(String args[]) {
        Cp0677 cp = new Cp0677();
        MapSum mapSum = cp.new MapSum();
        mapSum.insert("appled", 2);
        mapSum.insert("apple", 3);
        mapSum.insert("apple", 2);
        int result = mapSum.sum("ap");
        System.out.print(result);
    }

    // Main idea: trie.
    // Time: O(n).
    // Space: O(n).
    class MapSum {
        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            TrieNode cur = root;
            List<TrieNode> visited = new ArrayList<>();
            for (char ch : key.toCharArray()) {
                if (cur.next[ch - 'a'] == null) {
                    cur.next[ch - 'a'] = new TrieNode();
                }
                cur = cur.next[ch - 'a'];
                visited.add(cur);
            }
            int diff = val - cur.val;
            cur.val = val;
            for (TrieNode node : visited) {
                node.sum += diff;
            }
        }

        public int sum(String prefix) {
            TrieNode cur = root;
            for (char ch : prefix.toCharArray()) {
                if (cur.next[ch-'a'] == null) {
                    return 0;
                }
                cur = cur.next[ch-'a'];
            }
            return cur.sum;
        }
    }

    class TrieNode {
        TrieNode[] next;
        int sum;
        int val;

        public TrieNode() {
            next = new TrieNode[26];
            sum = 0;
            val = 0;
        }
    }

}

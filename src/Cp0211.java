// https://leetcode.com/problems/design-add-and-search-words-data-structure/

public class Cp0211 {
    public static void main(String args[]) {
    }

    // Main idea: trie.
    // Time: O(n).
    // Space: O(n).
    class WordDictionary {
        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode cur = root;
            for (Character ch : word.toCharArray()) {
                if (cur.next[ch - 'a'] == null) {
                    cur.next[ch - 'a'] = new TrieNode();
                }
                cur = cur.next[ch - 'a'];
            }
            cur.isWord = true;
        }

        public boolean search(String word) {
            return searchHelper(0, word.toCharArray(), root);
        }

        private boolean searchHelper(int cur, char[] chars, TrieNode node) {
            if (cur == chars.length) {
                return node.isWord;
            }
            if (chars[cur] == '.') {
                for (int j = 0; j < 26; j++) {
                    if (node.next[j] != null && searchHelper(cur + 1, chars, node.next[j])) {
                        return true;
                    }
                }
                return false;
            } else {
                if (node.next[chars[cur] - 'a'] == null) {
                    return false;
                }
                return searchHelper(cur + 1, chars, node.next[chars[cur] - 'a']);
            }
        }

        class TrieNode {
            TrieNode[] next = new TrieNode[26];
            boolean isWord = false;
        }
    }
}

// https://leetcode.com/problems/implement-trie-prefix-tree/

public class Cp0208 {
    public static void main(String args[]) {

    }

    class Trie {
        TrieNode root;
        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode index = root;
            for(char ch : word.toCharArray()) {
                if(index.next[ch-'a'] == null) {
                    index.next[ch-'a'] = new TrieNode();
                }
                index = index.next[ch-'a'];
            }
            index.isWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode index = root;
            for(char ch : word.toCharArray()) {
                if(index.next[ch-'a'] == null) {
                    return false;
                }
                index = index.next[ch-'a'];
            }
            return index.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode index = root;
            for(char ch : prefix.toCharArray()) {
                if(index.next[ch-'a'] == null) {
                    return false;
                }
                index = index.next[ch-'a'];
            }
            return true;
        }

        class TrieNode{
            TrieNode[] next = new TrieNode[26];
            boolean isWord = false;
        }
    }
}

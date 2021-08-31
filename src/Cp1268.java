// https://leetcode.com/problems/search-suggestions-system/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cp1268 {
    public static void main(String args[]) {
        Cp1268 cp = new Cp1268();
        String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
        List<List<String>> result = cp.suggestedProducts(products, "mouse");
        System.out.print(result);
    }

    class TrieNode {
        TrieNode[] children;
        String s;
        List<String> suggestions;

        public TrieNode() {
            children = new TrieNode[26];
            s = null;
            suggestions = new ArrayList<>();
        }

        public void update(String product) {
            if (!this.suggestions.contains(product)) {
                this.suggestions.add(product);
            }
            Collections.sort(suggestions);
            if (suggestions.size() > 3) {
                suggestions.remove(suggestions.size() - 1);
            }
        }
    }

    private TrieNode root;
    private TrieNode cur;

    // Main idea: trie.
    // Time: O(m * n), m: average length of product, n: products size.
    // Space: O(m * n).
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        root = new TrieNode();
        cur = root;
        for (String product : products) {
            add(product);
        }
        return search(searchWord);
    }

    private void add(String product) {
        TrieNode temp = root;
        for (char ch : product.toCharArray()) {
            if (temp.children[ch - 'a'] == null) {
                temp.children[ch - 'a'] = new TrieNode();
            }
            temp = temp.children[ch - 'a'];
            temp.update(product);
        }
        temp.s = product;
    }

    List<List<String>> search(String product) {
        List<List<String>> result = new ArrayList<>();
        int i = 0;
        for (; i < product.length(); i++) {
            if (cur.children[product.charAt(i) - 'a'] != null) {
                result.add(new ArrayList<>(cur.children[product.charAt(i) - 'a'].suggestions));
                cur = cur.children[product.charAt(i) - 'a'];
            } else {
                break;
            }
        }
        while (i++ < product.length()) {
            result.add(new ArrayList<>());
        }
        return result;
    }
}

// https://leetcode.com/problems/synonymous-sentences/

import java.util.*;

public class Cp1258 {
    public static void main(String args[]) {
    }

    // Main idea: bfs.
    // Time: O(n^m), n: number of words in the text, m is the number of synonyms.
    // Space: O(1).
    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, List<String>> graph = new HashMap<>();
        for (List<String> pair : synonyms) {
            String w1 = pair.get(0), w2 = pair.get(1);
            graph.computeIfAbsent(w1, t -> new LinkedList<>()).add(w2);
            graph.computeIfAbsent(w2, t -> new LinkedList<>()).add(w1);
        }
        Set<String> ans = new TreeSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(text);
        while (!q.isEmpty()) {
            String out = q.remove();
            ans.add(out); // Add to result
            String[] words = out.split("\\s");
            for (int i = 0; i < words.length; i++) {
                if (graph.get(words[i]) == null) continue;
                for (String synonym : graph.get(words[i])) { // Replace words[i] with its synonym
                    words[i] = synonym;
                    String newText = String.join(" ", words);
                    if (!ans.contains(newText)) q.add(newText);
                }
            }
        }
        return new ArrayList<>(ans);
    }
}

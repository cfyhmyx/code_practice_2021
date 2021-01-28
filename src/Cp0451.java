import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cp0451 {
    public static void main(String args[]) {
        Cp0451 cp = new Cp0451();
        String result = cp.frequencySort("Aabb");
        System.out.println(result);
    }

    // Main idea: bucket sort.
    // Time: O(n).
    // Space: O(n).
    public String frequencySort(String s) {
        if (s.isEmpty()) return s;
        List<Character>[] bucket = new List[s.length()+1];
        Map<Character, Integer> frequency = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (Character ch : frequency.keySet()) {
            if (bucket[frequency.get(ch)] == null) {
                bucket[frequency.get(ch)] = new ArrayList<>();
            }
            bucket[frequency.get(ch)].add(ch);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (Character ch : bucket[i]) {
                    for (int j=0; j<frequency.get(ch); j++) {
                        sb.append(ch);
                    }
                }
            }
        }
        return sb.toString();
    }
}

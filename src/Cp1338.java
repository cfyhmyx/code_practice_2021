// https://leetcode.com/problems/reduce-array-size-to-the-half/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cp1338 {
    public static void main(String args[]) {
    }

    // Main idea: bucket sort.
    // Time: O(n).
    // Space: O(n).
    public int minSetSize(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[n + 1];
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int curLen = 0;
        int result = 0;
        for (int pos = bucket.length - 1; pos > 0; pos--) {
            if (bucket[pos] != null) {
                for (int num : bucket[pos]) {
                    result++;
                    curLen += pos;
                    if (curLen >= n/2) {
                        return result;
                    }
                }
            }
        }
        return result;
    }
}

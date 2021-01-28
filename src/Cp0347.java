// https://leetcode.com/problems/top-k-frequent-elements/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cp0347 {
    public static void main(String args[]) {
        Cp0347 cp = new Cp0347();
        int[] nums = {1,1,1,2,2,3};
        int[] result = cp.topKFrequent(nums, 2);
        for (int num : result) {
            System.out.println(num);
        }
    }

    // Main idea: bucket sort.
    // Time: O(n).
    // Space: O(n).
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int n : nums) {
            frequencyMap.put(n, frequencyMap.getOrDefault(n, 0) + 1);
        }

        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (bucket[frequency] == null) {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] res = new int[k];
        int index = 0;

        for (int pos = bucket.length - 1; pos >= 0 && index < k; pos--) {
            if (bucket[pos] != null) {
                for (int num : bucket[pos]) {
                    res[index++] = num;
                }
            }
        }
        return res;
    }
}

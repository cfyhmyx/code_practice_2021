// https://leetcode.com/problems/dot-product-of-two-sparse-vectors/

import java.util.HashMap;
import java.util.Map;

public class Cp1570 {
    public static void main(String args[]) {
        Cp1570 cp = new Cp1570();
        int[] nums1 = {1, 0, 0, 2, 3};
        int[] nums2 = {0, 3, 0, 4, 0};
        int result = cp.calculation(nums1, nums2);
        System.out.println(result);
    }

    int calculation(int[] nums1, int[] nums2) {
        SparseVector sv1 = new SparseVector(nums1);
        SparseVector sv2 = new SparseVector(nums2);
        return sv1.dotProduct(sv2);
    }

    // Main idea: map.
    // Time: O(n).
    // Space: O(n).
    class SparseVector {
        Map<Integer, Integer> map;

        SparseVector(int[] nums) {
            Map<Integer, Integer> newMap = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    newMap.put(i, nums[i]);
                }
            }
            map = newMap;
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            if (map.keySet().size() > vec.map.keySet().size()) {
                return vec.dotProduct(this);
            }
            int result = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                result += entry.getValue() * vec.map.getOrDefault(entry.getKey(), 0);
            }
            return result;
        }
    }
}

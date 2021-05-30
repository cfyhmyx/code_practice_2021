// https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/

import java.util.*;

public class Cp0381 {
    public static void main(String args[]) {
    }

    // Main idea: map, set, array, swap.
    // Time: init: O(1).
    // Space: O(n).
    public class RandomizedCollection {
        List<Integer> elements;
        Map<Integer, Set<Integer>> index;
        java.util.Random rand = new java.util.Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedCollection() {
            elements = new ArrayList<>();
            index = new HashMap<>();
        }

        /**
         * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
         */
        public boolean insert(int val) {
            boolean contain = index.containsKey(val);
            if (!contain) index.put(val, new LinkedHashSet<>());
            index.get(val).add(elements.size());
            elements.add(val);
            return !contain;
        }

        /**
         * Removes a value from the collection. Returns true if the collection contained the specified element.
         */
        public boolean remove(int val) {
            boolean contain = index.containsKey(val);
            if (!contain) return false;
            int idx = index.get(val).iterator().next();
            index.get(val).remove(idx);
            if (idx < elements.size() - 1) {
                int lastEle = elements.get(elements.size() - 1);
                elements.set(idx, lastEle);
                index.get(lastEle).remove(elements.size() - 1);
                index.get(lastEle).add(idx);
            }
            elements.remove(elements.size() - 1);
            if (index.get(val).isEmpty()) index.remove(val);
            return true;
        }

        /**
         * Get a random element from the collection.
         */
        public int getRandom() {
            return elements.get(rand.nextInt(elements.size()));
        }
    }

}

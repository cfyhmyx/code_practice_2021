// https://leetcode.com/problems/insert-delete-getrandom-o1/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cp0380 {
    public static void main(String args[]) {
    }

    // Main idea: map, array, swap.
    // Time: init: O(1).
    // Space: O(n).
    public class RandomizedSet {
        Map<Integer, Integer> index;
        List<Integer> elements;
        java.util.Random rand = new java.util.Random();

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
            elements = new ArrayList<Integer>();
            index = new HashMap<Integer, Integer>();
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (index.containsKey(val)) {
                return false;
            }
            index.put(val, elements.size());
            elements.add(val);
            return true;
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (!index.containsKey(val)) {
                return false;
            }
            int idx = index.get(val);
            if (idx < elements.size() - 1) {
                int lastEle = elements.get(elements.size() - 1);
                elements.set(idx, lastEle);
                index.put(lastEle, idx);
            }
            index.remove(val);
            elements.remove(elements.size()-1);
            return true;
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            return elements.get(rand.nextInt(elements.size()));
        }
    }
}

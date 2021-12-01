// https://leetcode.com/problems/reveal-cards-in-increasing-order/

import java.util.*;

public class Cp0950 {
    public static void main(String args[]) {
    }

    // Main idea: simulation, deque.
    // Time: O(nlog(n)).
    // Space: O(n).
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> dq = new LinkedList<>();
        dq.add(deck[deck.length - 1]);
        for (int i = deck.length - 2; i >= 0; i--) {
            dq.addFirst(dq.removeLast());
            dq.addFirst(deck[i]);
        }
        int[] result = new int[deck.length];
        for (int i = 0; i < deck.length; i++) {
            result[i] = dq.pop();
        }
        return result;
    }
}

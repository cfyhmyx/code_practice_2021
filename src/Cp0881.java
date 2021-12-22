// https://leetcode.com/problems/boats-to-save-people/

import java.util.Arrays;

public class Cp0881 {
    public static void main(String args[]) {
    }

    // Main idea: two pointers.
    // Time: O(nlog(n)).
    // Space: O(1).
    public int numRescueBoats(int[] people, int limit) {
        int i = 0, j = people.length - 1;
        Arrays.sort(people);
        int res = 0;
        while (i < j) {
            if (people[i] + people[j] <= limit)
                i++;
            j--;
            res++;
        }
        if (i == j) res++;
        return res;
    }
}

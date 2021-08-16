// https://leetcode.com/problems/circular-permutation-in-binary-representation/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Cp1238 {
    public static void main(String args[]) {
        Cp1238 cp = new Cp1238();
        List<Integer> result = cp.circularPermutation(3, 2);
        System.out.print(result);
    }

    // Main idea: bit, math.
    // Time: O(2^n).
    // Space: O(1).
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; ++i)
            res.add(start ^ i ^ i >> 1);
        return res;
    }

    /*public List<Integer> circularPermutation(int n, int start) {
        List<Integer> result = new ArrayList<>();
        result.add(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        if (helper(n, result, visited)) {
            return result;
        } else {
            return new ArrayList<>();
        }
    }

    private boolean helper(int n, List<Integer> path, Set<Integer> visited) {
        if (path.size() == 1 << n) {
            for (int i=0; i<n; i++) {
                if ((path.get(0) ^ (1 << i)) == path.get(path.size()-1)) {
                    return true;
                }
            }
            return false;
        }
        for (int i=0; i<n; i++) {
            int next = path.get(path.size()-1) ^ (1 << i);
            if (visited.contains(next)) continue;
            visited.add(next);
            path.add(next);
            if (helper(n, path, visited)) {
                return true;
            }
            visited.remove(next);
            path.remove(path.size()-1);
        }
        return false;
    }*/
}

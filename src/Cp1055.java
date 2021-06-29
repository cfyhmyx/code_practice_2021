// https://leetcode.com/problems/shortest-way-to-form-string/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cp1055 {
    public static void main(String args[]) {
        Cp1055 cp = new Cp1055();
        String source = "ab";
        String target = "abcbc";
        int result = cp.shortestWay(source, target);
        System.out.print(result);
    }

    // Main idea: binary search.
    // Time: O(n*log(m)).
    // Space: O(m).
    public int shortestWay(String source, String target) {
        char[] cs = source.toCharArray(), ts = target.toCharArray();
        int res = 1;
        List<Integer>[] idx = new List[26];
        for (int i = 0; i < 26; i++) idx[i] = new ArrayList<>();
        for (int i = 0; i < cs.length; i++) idx[cs[i] - 'a'].add(i);
        int j = 0;
        for (int i = 0; i < ts.length; ) {
            List<Integer> tar = idx[ts[i] - 'a'];
            if (tar.isEmpty()) return -1;
            int k = Collections.binarySearch(tar,j);
            if (k < 0) k = -k - 1;
            if (k == tar.size()) {
                res++;
                j = 0;
            } else {
                j = tar.get(k) + 1;
                i++;
            }

        }
        return res;
    }
}

// https://leetcode.com/problems/satisfiability-of-equality-equations/

public class Cp0990 {
    public static void main(String args[]) {
        Cp0990 cp = new Cp0990();
        String[] eqs = {"c==c","b==d","x!=z"};
        boolean result = cp.equationsPossible(eqs);
        System.out.print(result);
    }

    private int[] root = new int[26];

    // Main idea: union and find.
    // Time: O(n*C).
    // Space: O(1).
    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            root[i] = i;
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                union(eq.charAt(0) - 'a', eq.charAt(3) - 'a');
            }
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                if (find(eq.charAt(0) - 'a') == find(eq.charAt(3) - 'a')) {
                    return false;
                }
            }
        }
        return true;
    }

    private void union(int x1, int x2) {
        int root1 = find(x1);
        int root2 = find(x2);
        root[root1] = root2;
    }

    private int find(int x) {
        if (root[x] == x) {
            return x;
        }
        int r = find(root[x]);
        return root[x] = r;
    }
}

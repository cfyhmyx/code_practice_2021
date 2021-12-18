// https://leetcode.com/problems/all-possible-full-binary-trees/

import java.util.ArrayList;
import java.util.List;

public class Cp0894 {
    public static void main(String args[]) {
    }

    // Main idea: recursion.
    // Time: O(2^n).
    // Space: O(ns).
    public List<TreeNode> allPossibleFBT(int N) {
        if(N <= 0 || N % 2 == 0) return new ArrayList<>();
        List<TreeNode> res = new ArrayList<>();
        if(N == 1) {
            res.add(new TreeNode(0));
            return res;
        }
        for(int i = 1; i < N; i += 2) {
            List<TreeNode> leftSubTrees = allPossibleFBT(i);
            List<TreeNode> rightSubTrees = allPossibleFBT(N - i - 1);
            for(TreeNode l : leftSubTrees) {
                for(TreeNode r : rightSubTrees) {
                    TreeNode root = new TreeNode(0);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }
}

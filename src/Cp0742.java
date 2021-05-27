// https://leetcode.com/problems/closest-leaf-in-a-binary-tree/

import java.util.*;

public class Cp0742 {
    public static void main(String args[]) {
    }

    // Main idea: dfs, bfs.
    // Time: O(n).
    // Space: O(n).
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> backMap = new HashMap<>();   // store all edges that trace node back to its parent
        Queue<TreeNode> queue = new LinkedList<>();          // the queue used in BFS
        Set<TreeNode> visited = new HashSet<>();             // store all visited nodes

        TreeNode kNode = helper(root, k, backMap);
        queue.add(kNode);
        visited.add(kNode);

        while(!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if(curr.left == null && curr.right == null) {
                return curr.val;
            }
            if(curr.left != null && visited.add(curr.left)) {
                queue.add(curr.left);
            }
            if(curr.right != null && visited.add(curr.right)) {
                queue.add(curr.right);
            }
            if(backMap.containsKey(curr) && visited.add(backMap.get(curr))) {
                queue.add(backMap.get(curr));
            }
        }
        return -1; // never hit
    }

    private TreeNode helper(TreeNode root, int k, Map<TreeNode, TreeNode> backMap) {
        if(root.val == k) {
            return root;
        }
        if(root.left != null) {
            backMap.put(root.left, root);
            TreeNode left = helper(root.left, k, backMap);
            if(left != null) return left;
        }
        if(root.right != null) {
            backMap.put(root.right, root);
            TreeNode right = helper(root.right, k, backMap);
            if(right != null) return right;
        }
        return null;
    }
}

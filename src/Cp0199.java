// https://leetcode.com/problems/binary-tree-right-side-view/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Cp0199 {
    public static void main(String args[]) {
    }

    // Main idea: bfs
    // Time: O(n).
    // Space: O(n).
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int m = q.size();
            for(int i=0; i<m; i++) {
                TreeNode cur = q.poll();
                if(cur.left != null) {
                    q.add(cur.left);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                }
                if(i==m-1) {
                    result.add(cur.val);
                }
            }
        }
        return result;
    }
}

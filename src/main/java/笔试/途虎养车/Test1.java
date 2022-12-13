package 笔试.途虎养车;

/*
 * public class TreeNode {
 *   int val = 0;
 *   TreeNode left = null;
 *   TreeNode right = null;
 *   public TreeNode(int val) {
 *     this.val = val;
 *   }
 * }
 */

import work.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Test1 {
    Set<Integer> set = new HashSet<>();

    public int numColor(TreeNode root) {
        dfs(root);
        return set.size();
    }

    private void dfs(TreeNode root) {

        if (root == null) return;
        set.add(root.val);
        dfs(root.left);
        dfs(root.right);
    }
}

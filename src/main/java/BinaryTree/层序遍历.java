package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @author kai
 * @date 2022/1/26 下午6:09
 */
/*
给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。

输入：root = [3,9,20,null,null,15,7]
输出：[[3],[9,20],[15,7]]
        3
      9  20
       15  7
示例 2：

输入：root = [1]
输出：[[1]]
示例 3：

输入：root = []
输出：[]
 */
public class 层序遍历 {
    public static void main(String[] args) {
        Integer arr[] = {3, 9, 20, null, null, 15, 7};
        TreeNode bt = BuildBTree.createBT(arr);
        List<List<Integer>> lists = levelOrder(bt);
        System.out.println(lists);
    }

    static List<List<Integer>> res = new ArrayList();

    public static List<List<Integer>> levelOrder(TreeNode root) {
//        dfs(root, 0);
        bfs(root);
        return res;
    }

    public static void dfs(TreeNode root, int deep) {
        if (root == null) return;

        deep++;
        if (res.size() < deep) {
            res.add(new ArrayList());
        }
        List<Integer> list = res.get(deep - 1);
        list.add(root.val);
        dfs(root.left, deep);
        dfs(root.right, deep);
    }

    public static List<List<Integer>> bfs(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();//poll 弹出
                level.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(level);
        }
        return res;

    }
}

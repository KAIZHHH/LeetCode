package BinaryTree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author kai
 * @date 2022/1/26 下午11:40
 */
/*
给定一个二叉树，找出其最小深度。
最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
说明：叶子节点是指没有子节点的节点。
    3
   / \
  9  20
    /  \
   15   7
输入：root = [3,9,20,null,null,15,7]
输出：2
示例 2：

    2
   / \
      3
     / \
        4
       / \
          5
         / \
            6
输入：root = [2,null,3,null,4,null,5,null,6]
输出：5

 */
public class 二叉树的最小深度 {
    public static void main(String[] args) {
        Integer arr[] = {3,9,20,null,null,15,7};
        TreeNode bt = BuildBTree.createBT(arr);
        int i = minDepth(bt);

        System.out.println(i);
    }

    /**
     * DFS
     *
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) return 1;

        int min_depth = Integer.MAX_VALUE;

        int left = minDepth(root.left);
        if (root.left != null) min_depth = Math.min(left, min_depth);

        int right = minDepth(root.right);
        if (root.right != null) min_depth = Math.min(right, min_depth);

        return min_depth + 1;
    }

    /**
     * BFS
     *
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        int depth = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode poll = deque.poll();
                if (poll.left == null && poll.right == null) {
                    // 是叶子结点，直接返回depth，因为从上往下遍历，所以该值就是最小值
                    return depth;
                }
                if (poll.left != null) {
                    deque.offer(poll.left);
                }
                if (poll.right != null) {
                    deque.offer(poll.right);
                }
            }
        }
        return depth;
    }
}

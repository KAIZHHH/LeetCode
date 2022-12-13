package BinaryTree;

import CodeTop.BuildBTree;
import CodeTop.TreeNode;

/**
 * @author kai
 * @date 2022/5/29 下午9:18
 */
/*
给定二叉树
          1
         / \
        2   3
       / \
      4   5
它的长度是路径 [4,2,1,3] 或者 [5,2,1,3]

思路：计算左右子树的深度之和 取最大值

 */
public class 二叉树的直径 {
    static int maxd = 0;

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 4, 5};
        TreeNode bt = BuildBTree.createBT(nums);
        int i = diameterOfBinaryTree(bt);
        System.out.println(i);
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxd;
    }

    public static int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int Left = dfs(node.left);
        int Right = dfs(node.right);
        maxd = Math.max(Left + Right, maxd);//将每个节点最大直径(左子树深度+右子树深度)当前最大值比较并取大者
        return Math.max(Left, Right) + 1;//返回节点深度

    }
}

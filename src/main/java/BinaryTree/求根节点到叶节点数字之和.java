package BinaryTree;

import CodeTop.BuildBTree;
import CodeTop.TreeNode;

/**
 * @author kai
 * @date 2022/5/27 上午11:37
 */
/*
输入：root = [1,2,3]
输出：25
解释：
从根到叶子节点路径 1->2 代表数字 12
从根到叶子节点路径 1->3 代表数字 13
因此，数字总和 = 12 + 13 = 25

输入：root = [4,9,0,5,1]
输出：1026
解释：
从根到叶子节点路径 4->9->5 代表数字 495
从根到叶子节点路径 4->9->1 代表数字 491
从根到叶子节点路径 4->0 代表数字 40
因此，数字总和 = 495 + 491 + 40 = 1026

思路：1、preSum记录之前的结点和 10*preSum+root.val 2、遍历到叶子结点：没路了输出结果  不是则继续向下递归添加
 */
public class 求根节点到叶节点数字之和 {
    public static void main(String[] args) {
        Integer nums[] = {1, 2, 3};
        TreeNode treeNode = new BuildBTree().createBT(nums);
        int i = sumNumbers(treeNode);
        System.out.println(i);
    }

    public static int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}

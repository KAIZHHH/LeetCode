package BinaryTree;

import CodeTop.BuildBTree;
import CodeTop.TreeNode;

/**
 * @author kai
 * @date 2022/3/7 下午7:23
 */
/*
给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。

叶子节点 是指没有子节点的节点。

输入：root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
输出：true
解释：等于目标和的根节点到叶节点路径如上图所示。

输入：root = [1,2,3], targetSum = 5
输出：false
解释：树中存在两条根节点到叶子节点的路径：
(1 --> 2): 和为 3
(1 --> 3): 和为 4
不存在 sum = 5 的根节点到叶子节点的路径。

输入：root = [], targetSum = 0
输出：false
解释：由于树是空的，所以不存在根节点到叶子节点的路径。
 */
public class 路径总和 {
    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3};
        TreeNode bt = BuildBTree.createBT(nums);
        boolean b = hasPathSum(bt, 5);
        System.out.println(b);
    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) return false; // 为空退出

        // 如果是叶子节点  判断是否符合
        if (root.left == null && root.right == null) {
            return root.val == targetSum;

        }
        boolean left = hasPathSum(root.left, targetSum - root.val);
        boolean right = hasPathSum(root.right, targetSum - root.val);

        // 有一边符合都可以
        return left || right;
    }
}

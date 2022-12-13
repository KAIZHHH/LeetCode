package BinaryTree;

/**
 * @author kai
 * @date 2022/2/1 下午5:44
 */
/*
给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
差值是一个正数，其数值等于两值之差的绝对值。

输入：root = [4,2,6,1,3]
输出：1

输入：root = [1,0,48,null,null,12,49]
输出：1
 */
public class 二叉搜索树的最小绝对差 {
    TreeNode pre;// 记录上一个遍历的结点
    int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;
    }

    public void traversal(TreeNode root) {
        if (root == null) return;
        //左
        traversal(root.left);
        //中
        if (pre != null) {
            result = Math.min(result, root.val - pre.val);//找最小值 先初始result=Max
        }
        pre = root;
        //右
        traversal(root.right);
    }
}

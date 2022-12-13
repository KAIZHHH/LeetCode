package BinaryTree;

/**
 * @author kai
 * @date 2022/1/31 下午12:26
 */
/*
给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
有效 二叉搜索树定义如下：
节点的左子树只包含 小于 当前节点的数。
节点的右子树只包含 大于 当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

输入：root = [2,1,3]
输出：true

输入：root = [5,1,4,null,null,3,6]
输出：false
解释：根节点的值是 5 ，但是右子节点的值是 4 。
 */
public class 验证二叉搜索树_合法二叉搜索树 {
    public boolean isValidBST(TreeNode root) {
        return BST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean BST(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;
        return BST(root.left, min, root.val) && BST(root.right, root.val, max);
    }
}

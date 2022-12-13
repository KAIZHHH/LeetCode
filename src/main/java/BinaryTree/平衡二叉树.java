package BinaryTree;

/**
 * @author kai
 * @date 2022/1/27 下午11:44
 */
/*
一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class 平衡二叉树 {
    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public static int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}

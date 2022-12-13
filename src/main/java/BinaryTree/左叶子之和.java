package BinaryTree;

/**
 * @author kai
 * @date 2022/1/29 上午12:14
 */
/*
输入: root = [3,9,20,null,null,15,7]
输出: 24
解释: 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24

输入: root = [1]
输出: 0
 */
public class 左叶子之和 {
    public static void main(String[] args) {
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode bt = BuildBTree.createBT(arr);
        int i = sumOfLeftLeaves(bt);
        System.out.println(i);
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        int leftLeaves = sumOfLeftLeaves(root.left);
        int rightLeaves = sumOfLeftLeaves(root.right);
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        return leftLeaves + rightLeaves + sum;

    }
}

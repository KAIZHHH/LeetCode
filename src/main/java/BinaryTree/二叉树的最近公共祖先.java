package BinaryTree;

/**
 * @author kai
 * @date 2022/2/7 下午11:16
 */
/*
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出：3
解释：节点 5 和节点 1 的最近公共祖先是节点 3 。

输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出：5
解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。

输入：root = [1,2], p = 1, q = 2
输出：1
 */
public class 二叉树的最近公共祖先 {
    public static void main(String[] args) {
//        TreeNode a = new TreeNode(6, null, null);
//        TreeNode b = new TreeNode(6, null, null);
//
//        TreeNode p = new TreeNode(5, null, null);
//        TreeNode q = new TreeNode(1, null, null);
//        TreeNode root = new TreeNode(3, p, q);

        int[] nums = {3, 5, 1, 6, 2, 0, 8, -1, -1, 7, 4};
//        System.out.println(node);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        //p q任一为root本身则 返回root
        if (p == root || q == root) {
            return root;
        }
        //检查p q在root.left能否找到
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //检查p q在root.right能否找到
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //pq都在root.left(left不为空right为空)：最近公共祖先在root.left
        if (left != null && right == null) {
            return left;
        }
        //pq都在root.right(left为空right不为空)：最近公共祖先在root.right
        if (left == null && right != null) {
            return right;
        }
        //pq都在root两边：最近公共祖先在root.right
        if (left != null && right != null) {
            return root;
        }
        return null;


    }

    public static TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor1(root.left, p, q);
        TreeNode right = lowestCommonAncestor1(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}

package BinaryTree;

/**
 * @author kai
 * @date 2022/1/26 下午10:56
 * 1、root.left root.right 都为null 对称
 * 2、有一个为null 或者 值不相等 则不对称
 * 3、递归检查 子节点
 */
public class 对称二叉树 {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 2, 3, 4, 4, 3};
        TreeNode bt = BuildBTree.createBT(arr);
        boolean symmetric = isSymmetric(bt);
        System.out.println(symmetric);
    }

    public static boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);

    }

    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null && q != null) return false;
        if (p != null && q == null) return false;
        if (p.val != q.val) return false;
        return check(p.left, q.right) && check(p.right, q.left);
    }

}

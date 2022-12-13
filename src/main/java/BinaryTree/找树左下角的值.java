package BinaryTree;

/**
 * @author kai
 * @date 2022/1/30 上午12:23
 */
/*
给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
假设二叉树中至少有一个节点。

输入: root = [2,1,3]
输出: 1

输入: [1,2,3,4,null,5,6,null,null,7]
输出: 7
 */
public class 找树左下角的值 {
    private int Deep = -1;//记录结点的深度
    private int value = 0;//记录最深的左节点的值

    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root, 0);
        return value;
    }

    private void findLeftValue(TreeNode root, int deep) {
        if (root == null) return;
        if (root.left == null && root.right == null) {//先为 叶子结点
            if (deep > Deep) {//深度更深 才进行value替换 找到左下角
                value = root.val;
                Deep = deep;
            }
        }
        //往下搜索
        if (root.left != null) findLeftValue(root.left, deep + 1);
        if (root.right != null) findLeftValue(root.right, deep + 1);
    }
}

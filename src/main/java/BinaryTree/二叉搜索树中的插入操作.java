package BinaryTree;

/**
 * @author kai
 * @date 2022/2/9 下午6:38
 */
/*
给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。
输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。

输入：root = [4,2,7,1,3], val = 5
输出：[4,2,7,1,3,5]
解释：另一个满足题目要求可以通过的树是：

输入：root = [40,20,60,10,30,50,70], val = 25
输出：[40,20,60,10,30,50,70,null,null,25]
示例 3：

输入：root = [4,2,7,1,3,null,null,null,null,null,null], val = 5
输出：[4,2,7,1,3,5]
 */
public class 二叉搜索树中的插入操作 {
    public static void main(String[] args) {
        Integer[] arr = {40, 20, 60, 10, 30, 50, 70};
        TreeNode bt = BuildBTree.createBT(arr);
        TreeNode treeNode = insertIntoBST(bt, 25);
        System.out.println(treeNode);

    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        // 如果当前节点为空，也就意味着val找到了合适的位置，此时创建节点直接返回。
        if (root == null) return new TreeNode(val);

        if (val > root.val) root.right = insertIntoBST(root.right, val); // 递归创建右子树
        if (val < root.val) root.left = insertIntoBST(root.left, val); // 递归创建左子树

        return root;
    }
}


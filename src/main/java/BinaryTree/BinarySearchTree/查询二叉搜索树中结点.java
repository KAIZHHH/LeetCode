package BinaryTree.BinarySearchTree;

/**
 * @author kai
 * @date 2022/2/10 上午1:17
 */
/*
给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。
如果节点不存在，则返回 null 。

输入：root = [4,2,7,1,3], val = 2
输出：[2,1,3]

输入：root = [4,2,7,1,3], val = 5
输出：[]
 */
public class 查询二叉搜索树中结点 {
    public Node search(Node root, int val) {
//        if (root == null || root.val == val) {
//            return root;
//        }
//        if ( val<root.val ) {
//            return search(root.left, val);
//        }
//        return search(root.right, val);
        return root == null || root.val == val ? root : search(val > root.val ? root.right : root.left, val);
    }
}

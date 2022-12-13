package BinaryTree.BinarySearchTree;

/**
 * @author kai
 * @date 2022/2/10 上午12:40
 */
public class 插入二叉搜索树中结点 {
    public Node insert(Node root, int val) {
        if (root == null) {
            return new Node(val);
        }
        if (val < root.val) root.left = insert(root.left, val);
        if (val > root.val) root.right = insert(root.right, val);

        return root;
    }
}

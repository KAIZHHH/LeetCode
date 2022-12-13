package BinaryTree.BinarySearchTree;

/**
 * @author kai
 * @date 2022/2/10 上午12:39
 */
public class 删除二叉搜索树中结点 {
    public Node delete(Node root, int val) {
        if (root == null) {
            return null;
        }
        if (val > root.val) {
            root.right = delete(root.right, val);
        } else if (val < root.val) {
            root.left = delete(root.left, val);
        } else {//(val == node.val)找到删除结点
            //只有一个结点情况:
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            //两个结点情况：
            Node minNode = minNode(root.right);//找到右子树最小结点
            root.val = minNode.val;//最小结点赋值到node位置
            root.right = delete(root.right, minNode.val);//删除最小结点的位置
        }
        return root;
    }

    private Node minNode(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        //直到node.left==null：说明当前node是最小节点
        return node;
    }
}

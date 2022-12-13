package 笔试.bilibili;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}

public class Test {
    static TreeNode head, pre;

    public static TreeNode Convert(TreeNode node) {
        if (node == null) return null;
        dfs(node);
        return head;
    }

    public static void dfs(TreeNode node) {
        if (node.left != null) {
            dfs(node.left);
        }
        if (pre != null) {
            pre.right = node;
        } else {
            head = node;
        }
        node.left = pre;
        pre = node;
        if (node.right != null) {
            dfs(node.right);
        }
    }
}

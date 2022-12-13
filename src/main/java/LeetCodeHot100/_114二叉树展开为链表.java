package LeetCodeHot100;

import CodeTop.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kai
 * @date 2022/7/25 下午8:48
 */
/*
输入：root = [1,2,5,3,4,null,6]
输出：[1,null,2,null,3,null,4,null,5,null,6]
示例 2：

输入：root = []
输出：[]
示例 3：

输入：root = [0]
输出：[0]
 */
public class _114二叉树展开为链表 {
    public static void main(String[] args) {
        TreeNode a = new TreeNode(3, null, null);
        TreeNode b = new TreeNode(4, null, null);
        TreeNode c = new TreeNode(2, a, b);
        TreeNode d = new TreeNode(6, null, null);
        TreeNode e = new TreeNode(5, null, d);
        TreeNode root = new TreeNode(1, c, e);
        flatten(root);
        System.out.println(root);
    }

    public static void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        preorderTraversal(root, list);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1);
            TreeNode curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public static void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}

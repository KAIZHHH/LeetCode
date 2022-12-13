package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kai
 * @date 2022/1/31 上午12:19
 */
/*
给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。

输入：     postorder = [9,15,7,20,3]
           inorder = [9,3,15,20,7],
输出：[3,9,20,null,null,15,7]
示例 2:

输入：inorder = [-1], postorder = [-1]
输出：[-1]
 */
public class 从中序与后序遍历序列构造二叉树 {
    public static void main(String[] args) {
        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode node = buildTree(postorder, inorder);
        System.out.println(node);
    }

    public static TreeNode buildTree(int[] postorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public static TreeNode build(int[] postorder, int poststart, int postend, int[] inorder, int instart, int inend, Map map) {
        if (instart > inend || poststart > postend) {
            return null;
        }

        int rootVal = postorder[postend];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = (int) map.get(rootVal);
        int len = rootIndex - instart;//长度
        root.left = build(postorder, poststart, poststart + len - 1, inorder, instart, rootIndex - 1, map);
        root.right = build(postorder, poststart + len, postend - 1, inorder, rootIndex + 1, inend, map);
        return root;
    }
}

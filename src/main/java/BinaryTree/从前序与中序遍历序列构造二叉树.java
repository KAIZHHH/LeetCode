package BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kai
 * @date 2022/1/31 上午12:19
 */
/*
给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。

输入: preorder = [3,9,20,15,7]
      inorder = [9,3,15,20,7]
输出: [3,9,20,null,null,15,7]
示例 2:

输入: preorder = [-1], inorder = [-1]
输出: [-1]

 */
public class 从前序与中序遍历序列构造二叉树 {
    public static void main(String[] args) {
        int[] preorder = {1, 1, 2};
        int[] inorder = {1, 2, 1};
        TreeNode node = buildTree(preorder, inorder);
        System.out.println(node);
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public static TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend, Map map) {
        // 递归终止条件
        if (instart > inend || prestart > preend) return null;

        int rootVal = preorder[prestart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = (int) map.get(rootVal);
        int len = rootIndex - instart;

        root.left = build(preorder, prestart + 1, prestart + len, inorder, instart, rootIndex - 1, map);
        root.right = build(preorder, prestart + len + 1, preend, inorder, rootIndex + 1, inend, map);
        return root;
    }
}

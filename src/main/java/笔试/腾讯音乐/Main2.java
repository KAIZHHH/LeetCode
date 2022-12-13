package 笔试.腾讯音乐;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kai
 * @date 2022/9/8 下午7:24
 */


public class Main2 {
//    public ArrayList<TreeNode> getBinaryTrees(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
//        int[] preorder = new int[preOrder.size()];
//        for (int i = 0; i < preOrder.size(); i++) {
//            preorder[i] = preOrder.get(i);
//        }
//        int[] inorder = new int[inOrder.size()];
//        for (int i = 0; i < inOrder.size(); i++) {
//            inorder[i] = inOrder.get(i);
//        }
//        TreeNode treeNode = buildTree(preorder, inorder);
//        System.out.println();
//    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }

    public static TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend, Map map) {
        if (instart > inend || prestart > preend) {
            return null;
        }
        int rootVal = preorder[prestart];
        TreeNode root = new TreeNode(rootVal);
        int rootIndex = (int) map.get(rootVal);
        int len = rootIndex - instart;

        root.left = build(preorder, prestart + 1, prestart + len, inorder, instart, rootIndex - 1, map);
        root.right = build(preorder, prestart + len + 1, preend, inorder, rootIndex + 1, inend, map);
        return root;
    }
}

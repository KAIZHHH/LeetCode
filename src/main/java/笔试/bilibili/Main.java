package 笔试.bilibili;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author kai
 * @date 2022/9/20 下午8:25
 */
class BuildBTree {
    public static TreeNode createBT(Integer[] array) {
        if (array.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(array[0]);
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addFirst(root);
        boolean isLeft = true;
        for (int i = 1; i < array.length; i++) {
            TreeNode node = deque.getLast();
            if (isLeft) {
                if (array[i] != null) {
                    node.left = new TreeNode(array[i]);
                    deque.addFirst(node.left);
                }
                isLeft = false;
            } else {
                if (array[i] != null) {
                    node.right = new TreeNode(array[i]);
                    deque.addFirst(node.right);
                }
                deque.removeLast();
                isLeft = true;
            }
        }
        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {10, 6, 14, 4, 7, 12, 20};
        TreeNode bt = BuildBTree.createBT(arr);
        List<Integer> list = inorderTraversal(bt);
        System.out.println(list);
    }

    static List<Integer> res = new ArrayList<>();

    //DFS
    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) return new ArrayList();
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }

}

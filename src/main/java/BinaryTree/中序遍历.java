package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author kai
 * @date 2022/1/26 下午5:28
 */
public class 中序遍历 {
    List<Integer> res = new ArrayList<>();

    //DFS
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList();
        }
        inorderTraversal(root.left);
        res.add(root.val);
        inorderTraversal(root.right);
        return res;
    }

    //BFS
    public static List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {//有一个true就进入循环
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else {//cur叶子结点时弹出
                cur = stack.pop();
                list.add(cur.val);
                cur = cur.right;
            }
        }
        return list;
    }

}

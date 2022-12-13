package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @author kai
 * @date 2022/1/26 下午5:28
 */
public class 前序遍历 {
    List<Integer> result = new ArrayList();


    public static void main(String[] args) {
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode node = new TreeNode(1, left, right);
        List<Integer> list = preorderTraversal1(node);
        System.out.println(Arrays.toString(list.toArray()));

    }

    //DFS
    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        result.add(root.val);           // 注意这一句
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return result;
    }

    //BFS
    public static List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);//处理中结点：先放
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();//弹出
            if (pop != null) {
                list.add(pop.val);
            } else {
                //pop == null
                continue;//如果root==null，后面不执行 重新执行while循环
            }
            stack.push(pop.right);
            stack.push(pop.left);
        }
        return list;
    }
}

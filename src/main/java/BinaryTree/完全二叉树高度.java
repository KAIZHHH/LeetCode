package BinaryTree;

import CodeTop.BuildBTree;
import CodeTop.TreeNode;

/**
 * @author kai
 * @date 2022/1/28 上午10:49
 */
//找到一个最大的
public class 完全二叉树高度 {
    public static void main(String[] args) {
        Integer nums[] = {1, 2, 3, 4, 5, 6};
        TreeNode bt = BuildBTree.createBT(nums);
        int i = countLevel(bt);
        System.out.println(i);
    }

    public static int countLevel(CodeTop.TreeNode root) {
        if (root == null) return 0;
        return Math.max(countLevel(root.left), countLevel(root.right)) + 1;//+root
    }
}

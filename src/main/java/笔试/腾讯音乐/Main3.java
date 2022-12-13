package 笔试.腾讯音乐;

import work.TreeNode;

/**
 * @author kai
 * @date 2022/9/18 下午2:03
 */
/*
3. 给定某二叉树，其节点要么没有子节点，要么就是两个子节点。
给每个节点赋正整数的值，使得一个节点，它的左右两边节点和相等。求最小的节点总和。
解法：后序遍历，return Math.max(left, right) + 1。尽可能赋最小的1.
 */
public class Main3 {
    public int process(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = process(root.left);
        int right = process(root.right);
        if (left == right) {
            root.val = root.left.val + root.right.val + 1;
        } else {
            root.val = root.left.val > root.right.val ? 2 * root.left.val + 1:root.right.val + 1;
        }
        return root.val % (10 ^ 9 + 7);
    }
}

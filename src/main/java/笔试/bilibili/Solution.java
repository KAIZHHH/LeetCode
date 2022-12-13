//package 笔试.bilibili;
//
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//}
//public class Solution {
//    static TreeNode pre;
//    public static void change(TreeNode root) {
//        if (root == null) return;
//
//        change(root.left);
//        root.left = pre;
//        if (pre != null) {
//            pre.right = root;
//        }
//        pre = root;
//        change(root.right);
//    }
//
//    public static TreeNode Convert(TreeNode pRootOfTree) {
//        if (pRootOfTree == null) return null;
//        change(pRootOfTree);
//        TreeNode head = pRootOfTree;
//        while (head.left != null) {
//            head = head.left;
//        }
//        return head;
//    }
//}
//

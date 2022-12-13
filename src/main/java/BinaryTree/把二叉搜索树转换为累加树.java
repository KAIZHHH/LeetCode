package BinaryTree;

import CodeTop.BuildBTree;
import CodeTop.TreeNode;

/**
 * @author kai
 * @date 2022/2/10 下午6:32
 */
/*
将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
从右子树的右节点开始累加

输入：[4,1,6,0,2,5,7,null,null,null,3,null,null,null,8]
输出：[30,36,21,36,35,26,15,null,null,null,33,null,null,null,8]
 */
public class 把二叉搜索树转换为累加树 {
    static int sum = 0;

    public static void main(String[] args) {
        Integer[] nums = {4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8};

        CodeTop.TreeNode bt = BuildBTree.createBT(nums);
        TreeNode treeNode = convertBST(bt);
        System.out.println(treeNode);
    }

    public static CodeTop.TreeNode convertBST(CodeTop.TreeNode root) {

        if (root == null) {
            return null;
        }

        //1、先走到底部
        convertBST(root.right);
        //2、再加和
        sum += root.val;
        //3、再赋值回去
        root.val = sum;
        convertBST(root.left);
        return root;
    }

}

package BinaryTree;


import CodeTop.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author kai
 * @date 2022/3/10 下午9:18
 */
/*
给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。
（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。

输入：root = [3,9,20,null,null,15,7]
输出：[[3],[20,9],[15,7]]

输入：root = [1]
输出：[[1]]

输入：root = []
输出：[]
 */
public class 二叉树的锯齿形层序遍历 {
    public static void main(String[] args) {
        TreeNode right = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode root = new TreeNode(3, new TreeNode(9), right);
        List<List<Integer>> lists = zigzagLevelOrder(root);
        System.out.println(lists);
    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //1、先层序遍历
        level(root, 0);
        //2、将res集合中的奇数下标取倒数
        for (int i = 0; i < res.size(); i++) {
            List<Integer> list = res.get(i);
            if (i % 2 != 0) {
                Collections.reverse(list);
            }
        }
        return res;
    }

    //层序遍历
    public static void level(TreeNode root, int deep) {
        if (root == null)   return;
        deep++;
        if (res.size() < deep) {
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }
        List<Integer> item = res.get(deep - 1);
        item.add(root.val);
        level(root.left, deep);
        level(root.right, deep);


    }
}

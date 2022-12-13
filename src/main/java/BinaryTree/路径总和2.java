package BinaryTree;

import CodeTop.BuildBTree;
import CodeTop.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kai
 * @date 2022/5/28 下午3:03
 */
/*
输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
输出：[[5,4,11,2],[5,8,4,5]]

输入：root = [1,2,3], targetSum = 5
输出：[]

输入：root = [1,2], targetSum = 0
输出：[]

已知结点和 求路径：回溯
思路：1、每遍历一个结点都将val相加为num ，当遍历到叶子结点 且num=target 则添加
 */
public class 路径总和2 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Integer nums[] = {5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1};
        TreeNode bt = BuildBTree.createBT(nums);
        List<List<Integer>> lists = pathSum(bt, 22);
        System.out.println(lists);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, 0, sum);
        return res;
    }

    public static void dfs(TreeNode root, int num, int sum) {
        if (root == null) return;
        num += root.val;
        list.add(root.val);
        //1、叶子结点 2、满足和sum ->添加元素
        if (num == sum && root.left == null && root.right == null) {
            res.add(new ArrayList(list));
        }
        dfs(root.left, num, sum);
        dfs(root.right, num, sum);
        list.remove(list.size() - 1);
    }
}

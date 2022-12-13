package BackTracking;

import BinaryTree.BuildBTree;
import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kai
 * @date 2022/1/28 下午4:22
 */
/*
给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。叶子节点 是指没有子节点的节点。

输入：root = [1,2,3,null,5]
输出：["1->2->5","1->3"]

输入：root = [1]
输出：["1"]
 */
public class 二叉树的所有路径 {
    static List<String> res = new ArrayList();

    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, null, 5};
        TreeNode bt = BuildBTree.createBT(nums);
        List<String> strings = binaryTreePaths(bt);
        System.out.println(strings);
    }

    public static List<String> binaryTreePaths(TreeNode root) {
        constructPaths(root, "");
        return res;
    }

    public static void constructPaths(TreeNode root, String path) {
        if (root != null) {
            StringBuffer sb = new StringBuffer(path);
            sb.append(root.val);
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                res.add(sb.toString());  // 把路径加入到答案中
            } else {
                sb.append("->");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, sb.toString());
                constructPaths(root.right, sb.toString());
            }
        }
    }
}

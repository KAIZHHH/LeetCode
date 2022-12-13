package BinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kai
 * @date 2022/2/7 下午10:33
 */
/*
给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
如果树中有不止一个众数，可以按 任意顺序 返回。

假定 BST二叉搜索树 满足如下定义：
结点左子树中所含节点的值 小于等于 当前节点的值
结点右子树中所含节点的值 大于等于 当前节点的值
左子树和右子树都是二叉搜索树

输入：root = [1,null,2,2]
输出：[2]
示例 2：

输入：root = [0]
输出：[0]

 */
public class 二叉搜索树中的众数 {
    static Map<Integer, Integer> map = new HashMap<>();
    static int max = Integer.MIN_VALUE;
    static List<Integer> list = new ArrayList<Integer>();

    public static void main(String[] args) {
        Integer[] num = {1, null, 2, 2};
        TreeNode bt = BuildBTree.createBT(num);
        int[] mode = findMode(bt);
        System.out.println(mode);
    }


    public static int[] findMode(TreeNode root) {
        traverse(root);
        //将集合转成指定类型数组
        int[] ints = list.stream().mapToInt(i -> i).toArray();

        return ints;
    }

    public static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);

        //修改map
        if (map.containsKey(root.val)) {
            map.put(root.val, map.get(root.val) + 1);
        } else {
            map.put(root.val, 1);
        }

        //修改list
        int temp = map.get(root.val);
        if (temp > max) {//key:root.val 对应的value值>max 则新创建一个集合 因为可能返回次数相同的 不同root.val
            max = temp;
            list = new ArrayList<Integer>();
            list.add(root.val);
        } else if (temp == max) {//key:root.val 对应的value值和当前的max 就在相等的集合中添加
            list.add(root.val);
        }
        traverse(root.right);
    }
}

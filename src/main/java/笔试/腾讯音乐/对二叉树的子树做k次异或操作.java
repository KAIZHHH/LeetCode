package 笔试.腾讯音乐;

import work.BuildBTree;
import work.TreeNode;

import java.util.*;

/**
 * @author kai
 * @date 2022/4/28 下午9:25
 */
/*

题目：给你一颗二叉树，树中的节点保存一个id，让你对这颗二叉树做k次操作[ak,bk]，
每次操作选择对应序号ak的二叉树结点，对以这个节点为根的子树中的所有节点(初始值为0)做异或操作，返回k次操作之后的树。
例如：给一棵二叉树[3,#,2,1]，k个操作[[1,3],[2,4],[3,5],[1,4]]，
你需要(1)对id为3的节点以及所有孩子节点对5做异或(2)对id为2的节点以及所有孩子节点对4做异或(3)对id为1的节点以及孩子节点分别对3和4做两次异或。

注意点1：题目给的树的val保存的是id，这个id和题目给的k次操作的每次操作的第0个元素对应，所以这里最直接的想法就是你要构造一棵和题目给的树相同但节点val为0的树copy；
注意点2：异或操作与顺序无关，对于[[1,2],[1,3],[1,4]]的操作，可以先处理为[[1,2^3^4]]=[[1,5]]
 */
public class 对二叉树的子树做k次异或操作 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(2);
        list2.add(4);
        ArrayList<Integer> list3 = new ArrayList<>();
        list3.add(3);
        list3.add(5);

        ArrayList<ArrayList<Integer>> op = new ArrayList();
        op.add(list1);
        op.add(list2);
        op.add(list3);
        Integer[] array = {1, null, 2, 3};
        TreeNode bt = new BuildBTree().createBT(array);
        TreeNode treeNode = xorTree(bt, op);
        System.out.println(treeNode);
    }

    public static TreeNode xorTree(TreeNode root, ArrayList<ArrayList<Integer>> op) {
        // write code here
        Map<Integer, TreeNode> table = new HashMap<>();
        Queue<TreeNode> que = new LinkedList<>();
        if (root != null) que.add(root);
        int num = 0;
        while (!que.isEmpty()) {
            TreeNode tmp = que.poll();
            num++;
            table.put(tmp.val, tmp);
            tmp.val = 0;
            if (tmp.left != null) que.offer(tmp.left);
            if (tmp.right != null) que.offer(tmp.right);
        }
        for (int i = 0; i < op.size(); i++) {
            List<Integer> tmp = op.get(i);
            int index = tmp.get(0);
            int nums = tmp.get(1);
            TreeNode node = table.get(index);
            helper(node, nums);
        }
        return root;
    }

    public static void helper(TreeNode root, int num) {
        if (root == null) return;
        root.val = root.val ^ num;
        if (root.left != null) helper(root.left, num);
        if (root.right != null) helper(root.right, num);
    }
}

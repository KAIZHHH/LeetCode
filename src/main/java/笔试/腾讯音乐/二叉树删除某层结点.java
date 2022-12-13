package 笔试.腾讯音乐;

import work.BuildBTree;
import work.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*

题目：给定一棵二叉树，让你删除树的某些层，返回删除后的所有子树。
例如：1、[1,1,1,1,1,1,#,1,1,#,1,#,1,1]，删除第[3]层，
应该返回[[1,1,1],[1,#,1],[1,1],[1]];2、[1,#,1,#,1,#,1,#,1]，
删除[2,4]层之后应该返回[[1],[1],[1]]
 */
public class 二叉树删除某层结点 {


    public static void main(String[] args) {
        Integer[] array = {1, 1, 1, null, 1, 1, null, 1, 1, null, null};
        ArrayList<Integer> a = new ArrayList<>();
        a.add(2);
        TreeNode bt = new BuildBTree().createBT(array);
        System.out.println(bt);
        ArrayList<TreeNode> treeNodes = deleteLevel(bt, a);
        System.out.println(treeNodes);
    }


    public static ArrayList<TreeNode> deleteLevel(TreeNode root, ArrayList<Integer> a) {
        ArrayList res = new ArrayList<>();

        // write code here
        Queue<TreeNode> que = new LinkedList<>();
        if (root != null) que.offer(root);
        int depth = 1;
        //如果不删第一层 就将第一层root添加进  结果的res
        if (!a.contains(1)) res.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            //遍历每层的结点数
            for (int i = 0; i < size; i++) {
                TreeNode tmp = que.poll();
                if (tmp.left != null) que.offer(tmp.left);
                if (tmp.right != null) que.offer(tmp.right);
                //如果要删除的是下一层 赋为null
                if (a.contains(depth + 1)) {
                    tmp.left = null;
                    tmp.right = null; //就斩断联系
                } else if (a.contains(depth)) { //如果此层就是要删除的那层
                    if (tmp.left != null) {
                        res.add(tmp.left);
                        tmp.left = null;
                    }
                    if (tmp.right != null) {
                        res.add(tmp.right);
                        tmp.right = null;
                    }
                }
            }
            depth++;
        }
        return res;
    }
}

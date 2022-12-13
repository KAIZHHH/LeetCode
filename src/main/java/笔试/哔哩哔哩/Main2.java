//package 笔试.哔哩哔哩;
//
//import BinaryTree.BuildBTree;
//import BinaryTree.TreeNode;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author kai
// * @date 2022/9/1 下午7:43
// */
//public class Main2 {
//    static List<List<Integer>> res = new ArrayList();
//
//    public static void main(String[] args) {
//        Integer arr[] = {3, 2, 3, 4};
//        TreeNode bt = BuildBTree.createBT(arr);
//        int i = maxValue(bt);
//
//        System.out.println(i);
//    }
//
//
//    public static List<List<Integer>> levelOrder(TreeNode root) {
//        dfs(root, 0);
//        return res;
//    }
//
//    public static void dfs(TreeNode root, int deep) {
//        if (root == null) return;
//
//        deep++;
//        if (res.size() < deep) {
//            res.add(new ArrayList());
//        }
//        List<Integer> list = res.get(deep - 1);
//        list.add(root.val);
//        dfs(root.left, deep);
//        dfs(root.right, deep);
//    }
//
//    public static int maxValue(TreeNode root) {
//
//    }
//
//    public static int[] get(List<List<Integer>> list) {
//        for (int i = 1; i < list.size(); i++) {
//            List<Integer> integer1 = list.get(i - 1);
//            List<Integer> integer2 = list.get(i);
//            int max = 0;
//            int s1 = 0;
//            int s2 = 0;
//            for (int j = 0; j < integer1.size(); j++) {
//                if (integer1.get(j) > max) {
//                    max = Math.max(integer1.get(j), max);
//                    s1 = j;
//                }
//
//            }
//            int min = 0;
//            for (int j = 0; j < integer2.size(); j++) {
//                if (integer2.get(j) < min) {
//                    min = Math.max(integer2.get(j), min);
//                    s2 = j;
//                }
//            }
//            int swap = swap(integer1, integer2, s1, s2, max, min);
//        }
//    }
//
//    public static int calculate(TreeNode root) {
//        List<List<Integer>> lists = levelOrder(root);
//        int max = 0;
//        for (List list : lists) {
//            int sum = 0;
//            for (Object i : list) {
//                int i1 = (int) i;
//                sum += i1;
//            }
//            max = Math.max(max, sum);
//        }
//        return max;
//    }
//
//    public static int swap(List<Integer> integer1, List<Integer> integer2, int s1, int s2, int max, int min) {
//        integer1.remove(s1);
//        integer2.remove(s2);
//        integer1.add(max);
//        integer2.add(min);
//
//    }
//
//}

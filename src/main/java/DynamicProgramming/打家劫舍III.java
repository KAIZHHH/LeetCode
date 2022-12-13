package DynamicProgramming;

import CodeTop.BuildBTree;
import CodeTop.TreeNode;

import java.util.HashMap;

/**
 * @author kai
 * @date 2022/5/4 下午9:43
 */
/*
保证不偷相邻结点的数
输入: root = [3,2,3,null,3,null,1]
输出: 7
解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7
 */
public class 打家劫舍III {
    static HashMap<TreeNode, Integer> map = new HashMap<>();

    public static int rob(TreeNode root) {
        if (root == null) return 0;


        //root!=null
        //根节点和孙子结点之和
        int sum = root.val;
        if (root.left != null) {
            sum += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            sum += +rob(root.right.left) + rob(root.right.right);
        }
        //儿子节点之和
        int sum1 = rob(root.left) + rob(root.right);
        int max = Math.max(sum, sum1);
        return max;
    }


    public static void main(String[] args) {
        Integer[] nums = {1, 2, 3, 2, 1, 1, 2};
        CodeTop.TreeNode node = new BuildBTree().createBT(nums);
        int rob = rob(node);
        System.out.println(rob);
    }


    public static int[] rob1(TreeNode root) {
        int[] res = new int[2];
        //res[0]:不选, 不rob //res[1]:选,rob int [res new int[2];
        if (root == null) return res;
        int[] left = rob1(root.left);
        int[] right = rob1(root.right);

        res[0] = 0 + Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
        return res;
    }
}

package DynamicProgramming;

/**
 * @author kai
 * @date 2022/2/20 下午4:26
 */
/*
给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
返回满足题意的二叉搜索树的种数。

输入：n = 3
输出：5

输入：n = 1
输出：1
 */
public class 不同的二叉搜索树 {
    public static void main(String[] args) {
        int i = numTrees(3);
        System.out.println(i);
    }

    public static int numTrees(int n) {
        //初始化 dp 数组
        int[] dp = new int[n + 1];
        //初始化0个节点和1个节点的情况
        dp[0] = 1;
        dp[1] = 1;
        for (int a = 2; a <= n; a++) {
            for (int b = 1; b <= a; b++) {
                //对于第n个节点，需要考虑1作为根节点直到n作为根节点的情况，所以需要累加

                //共a个节点，对于根节点b时,左子树的节点个数为b-1，右子树的节点个数为a-b
                //以b为根节点能构成的BST数量 b不断变 不断累加数量
                dp[a] += dp[b - 1] * dp[a - b];
            }
        }
        return dp[n];
    }
}

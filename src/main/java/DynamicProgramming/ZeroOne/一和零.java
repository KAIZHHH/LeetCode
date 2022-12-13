package DynamicProgramming.ZeroOne;

/**
 * @author kai
 * @date 2022/2/22 下午1:29
 */
/*
给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
请你找出并返回 strs 的最大子集的长度，该子集中 最多 有 m 个 0 和 n 个 1 。
如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。

输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
输出：4
解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4

其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。

输入：strs = ["10", "0", "1"], m = 1, n = 1
输出：2
解释：最大的子集是 {"0", "1"} ，所以答案是 2


 */
public class 一和零 {
    /**
     * 思路：把总共的 0 和 1 的个数视为背包的容量，每一个字符串视为装进背包的物品
     *
     * 动态规划的思路是：物品一个一个尝试，容量一点一点尝试，每个物品分类讨论的标准是：选与不选。
     *
     * 定义状态：尝试题目问啥，就把啥定义成状态。
     * dp[i][j][k] 表示输入字符串在子区间 [0, i] 能够使用 j 个 0 和 k 个 1 的字符串的最大数量。
     *
     * 状态转移方程：
     * dp[i][j][k]= \begin{cases} dp[i - 1][j][k], & 不选择当前考虑的字符串，至少是这个数值\\ dp[i - 1][j - 当前字符串使用 \;0\; 的个数][k - 当前字符串使用 \;1\; 的个数] + 1 & 选择当前考虑的字符串 \end{cases}
     * dp[i][j][k]={
     * dp[i−1][j][k],
     * dp[i−1][j−当前字符串使用0的个数][k−当前字符串使用1的个数]+1
     * ​
     *
     * 不选择当前考虑的字符串，至少是这个数值
     * 选择当前考虑的字符串
     * ​
     *
     *
     * 初始化：为了避免分类讨论，通常多设置一行。这里可以认为，第 00 个字符串是空串。第 00 行默认初始化为 00。
     * 输出：输出是最后一个状态，即：dp[len][m][n]。
     *
     * 作者：liweiwei1419
     * 链接：https://leetcode-cn.com/problems/ones-and-zeroes/solution/dong-tai-gui-hua-zhuan-huan-wei-0-1-bei-bao-wen-ti/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]表示i个0和j个1时的最大子集
        int[][] dp = new int[m + 1][n + 1];
        int oneNum, zeroNum;
        for (String str : strs) {
            oneNum = 0;
            zeroNum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }

            //倒序遍历
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }

}

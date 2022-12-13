package String;

/**
 * @author kai
 * @date 2022/4/26 上午10:01
 */
/*
视频：https://www.bilibili.com/video/BV1RS4y1P7zN?spm_id_from=333.337.search-card.all.click&vd_source=a81474b1b4d906df3173891054419ef2

给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。

输入：s = "bbbab"
输出：4
解释：一个可能的最长回文子序列为 "bbbb" 。
示例 2：

输入：s = "cbbd"
输出：2
解释：一个可能的最长回文子序列为 "bb" 。


     b b b a b
     0 0 0 0 0
   b 0
   b 0
   b 0
   a 0
   b 0       0
 */
public class 最长回文子序列_不连续dp_个数 {
    public static void main(String[] args) {
        int i = longestPalindromeSubseq("bbbab");
        System.out.println(i);
    }

    public static int longestPalindromeSubseq(String s) {
        //dp[i][j]表示字符串s 从i到j的 最长回文序列数
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;//********自己到自己 就一个字符 i 的回文序列为1*******
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                //字符下标i==字符下标j: a cbc a
                if (s.charAt(i) == s.charAt(j)) {
                    //长度=往中间收缩+2 ： i i+1   j-1 j
                    //                  a c   b  c  a
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    //不相等 长度=往左 或者 往右   i i+1   j-1 j
                    //                         a c   b  c  x
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.print(dp[i][j] + " ");
//            }
//            System.out.println();
//        }
        return dp[0][n - 1];
    }
}

package String;

/**
 * @author kai
 * @date 2022/4/23 下午8:58
 */
/*
判断t中是否包含s的子序列
输入：s = "abc", t = "ahbgdc"
输出：true
示例 2：

输入：s = "axc", t = "ahbgdc"
输出：false

思路：
1、lr指针分别从头往后遍历两个字符串
2、判断相同则累加sum
2、比较sum和s长度是否相同
 */
public class 判断子序列_不连续_双指针 {
    public static void main(String[] args) {
        String s = "acb";
        String t = "ahbgdc";
        boolean subsequence = isSubsequence1(s, t);
        System.out.println(subsequence);
    }

    //双指针
    /*
    时间复杂度：O(n+m)，其中 nn 为 ss 的长度，mm 为 tt 的长度。每次无论是匹配成功还是失败，都有至少一个指针发生右移，两指针能够位移的总距离为 n+mn+m。
    空间复杂度：O(1)。
     */
    public static boolean isSubsequence1(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    /*      a   h   b   g   c
            0   0   0   0   0
        a   1
        b
        c
     */
    //动态规划
    public static boolean isSubsequence(String s, String t) {
        //定义dp[i][j]表示 s中前i个字符 满足 t中前j个字符 的子序列数
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {//相等
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {//不相等
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }
}

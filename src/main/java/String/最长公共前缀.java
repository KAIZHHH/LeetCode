package String;

/**
 * @author kai
 * @date 2022/6/2 下午11:21
 */
/*
输入：strs = ["flower","flow","flight"]
输出："fl"
示例 2：

输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。

 */
public class 最长公共前缀 {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }
    //时间O(n^2) 空间O(1)
    public static String longestCommonPrefix(String[] strs) {
        String common = strs[0];
        for (int i = 1; i < strs.length; i++) {
            common = getCommon(common, strs[i]);
        }
        return common;
    }

    public static String getCommon(String s1, String s2) {
        int start = 0;
        int min = Math.min(s1.length(), s2.length());
        while (start < min) {
            if (s1.charAt(start) != s2.charAt(start)) {
                break;
            }
            start++;
        }
        return s1.substring(0, start);
    }
}

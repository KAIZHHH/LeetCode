package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kai
 * @date 2022/2/12 上午1:21
 */
/*
给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。

输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]
示例 2：

输入：s = "a"
输出：[["a"]]
 */
public class 分割回文串 {
    static List<List<String>> result = new ArrayList<>();
    static List<String> path = new ArrayList<>();

    public static void main(String[] args) {
        String s = "a";
        List<List<String>> partition = partition(s);
        System.out.println(partition);
    }

    public static List<List<String>> partition(String s) {
        dfs(s);
        return result;
    }

    public static void dfs(String s) {
        if (s.length() == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isPalindrome(s, 0, i)) {
                path.add(s.substring(0, i + 1));//左开右闭[)取到0-i
                dfs(s.substring(i + 1));//s.substring(i + 1, end)//默认截取剩下全部
                path.remove(path.size() - 1);
            }
        }
    }

    //判断回文字符串:回文串 是正着读和反着读都一样的字符串
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {//双指针
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;//有一个字符不满足就返回false
            }
        }
        return true;//全部满足 返回true
    }
}

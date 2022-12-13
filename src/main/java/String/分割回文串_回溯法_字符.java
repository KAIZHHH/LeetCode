package String;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kai
 * @date 2022/4/18 下午7:58
 */
/*
输入：s = "aab"
输出：[["a","a","b"],["aa","b"]]

输入：s = "a"
输出：[["a"]]

思路：
 */
public class 分割回文串_回溯法_字符 {
    static List<List<String>> result = new ArrayList<>();
    static List<String> path = new ArrayList<>();

    public static void main(String[] args) {
        List<List<String>> abvxd = partition("aab");
        System.out.println(abvxd);
    }

    public static List<List<String>> partition(String s) {
        dfs(s);
        return result;
    }

    public static void dfs(String s) {
        if (s.length() == 0) {//递归的s为0 证明到最后了 往res添加这一组
            result.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            //如果是回文
            if (isPalindrome(s, 0, i)) {//[0,i]满足回文
                path.add(s.substring(0, i + 1));//就添加[0,i]
                dfs(s.substring(i + 1));//递归剩余的
                path.remove(path.size() - 1);
            }
        }
    }

    //判断回文字符串:回文串 是正着读和反着读都一样的字符串
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}

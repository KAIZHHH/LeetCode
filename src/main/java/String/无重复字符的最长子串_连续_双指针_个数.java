package String;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kai
 * @date 2022/3/8 上午10:36
 */
/*
输入: s = "abcabcbb"
输出: 3

输入: s = "bbbbb"
输出: 1

输入: s = "pwwkew"
输出: 3

思路：
1、lr指针 r往后扫描不存在set 就添加到set
2、遇到存在的就删除l指针元素 取最大长度
 */
public class 无重复字符的最长子串_连续_双指针_个数 {
    public static void main(String[] args) {
        String s = "abceabcrvb";
        int i = lengthofLongestSubstring(s);
        System.out.println(i);
    }

    public static int lengthofLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) return 0;
        Set<Character> set = new HashSet();
        int l = 0;
        int r = 0;
        int res = 0;
        while (r < n) {
            if (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l++));
            } else {
                set.add(s.charAt(r++));
            }
            res = Math.max(res, set.size());
        }
        return res;
    }

}

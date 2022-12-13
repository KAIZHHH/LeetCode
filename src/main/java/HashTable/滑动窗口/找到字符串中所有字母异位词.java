package HashTable.滑动窗口;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kai
 * @date 2022/1/14 下午9:15
 */
/*
给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

输入: s = "cbaebabacd", p = "abc"
输出: [0,6]
解释:
起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。

输入: s = "abab", p = "ab"
输出: [0,1,2]
解释:
起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。

 */
public class 找到字符串中所有字母异位词 {
    public List<Integer> findAnagrams(String s, String p) {
        int[] s1 = new int[26];
        int[] p1 = new int[26];
        for (int i = 0; i < p.length(); i++) {
            p1[p.charAt(i) - 'a']++;//记录所需要字符的次数
        }
        List<Integer> list = new ArrayList<>();
        for (int r = 0, l = 0; r < s.length(); r++) {
            s1[s.charAt(r) - 'a']++;    //在s1数组中所存在的字符 次数++
            if (r - l + 1 > p.length()) {//窗口的长度大于所需字符串的长度
                s1[s.charAt(l) - 'a']--;//因为l指针右移 所以在s1数组中所存在的字符 次数-- 指针移动了 窗口不包含该字符了
                l++;
            }
            if (r - l + 1 == p.length()) {
                if (isSame(s1, p1)) {
                    list.add(l);

                }
            }
        }
        return list;
    }

    private boolean isSame(int[] s1, int[] p1) {
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != p1[i]) {
                return false;
            }

        }
        return true;
    }
}

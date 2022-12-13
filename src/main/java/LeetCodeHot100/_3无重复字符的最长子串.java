package LeetCodeHot100;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kai
 * @date 2022/6/24 上午12:14
 */
public class _3无重复字符的最长子串 {
    public static void main(String[] args) {
        String s = "abcccbd";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet();
        int n = s.length();
        int l = 0;
        int r = 0;
        int max = 0;
        while (r < n) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r++));
            } else {
                set.remove(s.charAt(l++));
            }
            max = Math.max(set.size(), max);
        }
        return max;
    }
}

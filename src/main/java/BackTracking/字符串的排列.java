package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
换句话说，s1 的排列之一是 s2 的 子串 。

输入：s1 = "ab" s2 = "eidbaooo"
输出：true
解释：s2 包含 s1 的排列之一 ("ba").

输入：s1= "ab" s2 = "eidboaoo"
输出：false

 */
class 字符串的排列 {
    static List<String> res = new ArrayList();
    static Boolean isUsed[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "ccccbbbbaaaa";
        boolean b = checkInclusion(s1, s2);
        System.out.println(b);
    }

    public static boolean checkInclusion(String s1, String s2) {
        isUsed = new Boolean[s1.length()];
        Arrays.fill(isUsed, false);
        dfs(s1);
        for (String str : res) {
            if (s2.contains(str)) return true;
        }
        return false;
    }

    public static void dfs(String s) {
        if (sb.length() == s.length()) {
            res.add(new StringBuilder(sb).toString());
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (isUsed[i] == true) continue;
//            if (i > 0 && s.charAt(i) == s.charAt(i - 1) && isUsed[i - 1] == false) continue;
            isUsed[i] = true;
            sb.append(s.charAt(i));
            dfs(s);
            sb.delete(sb.length() - 1, sb.length());
            isUsed[i] = false;
        }
    }
}

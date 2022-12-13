package Array.滑动窗口;

/**
 * @author kai
 * @date 2022/1/15 上午11:32
 */
/*
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
如果 s 中存在这样的子串，我们保证它是唯一的答案。

输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"
示例 2：

输入：s = "a", t = "a"
输出："a"
示例 3:

输入: s = "a", t = "aa"
输出: ""
解释: t 中两个字符 'a' 均应包含在 s 的子串中，
因此没有符合条件的子字符串，返回空字符串。
 */
public class 最小覆盖子串 {
    public static void main(String[] args) {
        String s = "CBDBANC";
        String t = "ABC";
        String s1 = minWindow(s, t);
        System.out.println(s1);
    }

    public static String minWindow(String s, String t) {
        if (s == null || s.length() == 0 || t == null || t.length() == 0) {
            return "";
        }
        int[] need = new int[128];
        //记录需要的字符的个数
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }


        int l = 0, r = 0;//左右指针
        int size = Integer.MAX_VALUE;//窗口大小 初始赋值为不可能的
        int count = t.length(); //count:记录还需要t中哪几个字符 最大是t.length
        int start = 0;//size记录窗口大小，start是最小覆盖串开始的index
        //遍历所有字符
        while (r < s.length()) {
            char c = s.charAt(r);//s中的c字符
            //表示t中包含当前遍历到的这个c字符，更新目前所需要的count数大小，应该减少一个
            if (need[c] > 0) {//遍历到的 s中的c字符 是所需要的！
                count--;      //所需要的数字-1
            }
            need[c]--;//所需要c字符的次数 -1


            if (count == 0) {//窗口中已经包含所有字符 开始过滤掉多余元素
                while (l < r && need[s.charAt(l)] < 0) {//左指针遍历的字符在need数组中次数如果是负数表明当前字符在窗口中是多余的，需要过滤掉
                    need[s.charAt(l)]++;//有多的字符过滤掉
                    l++;//指针右移

                }
                //如果当前的这个窗口值比之前维护的窗口值更小，需要进行更新
                if (r - l + 1 < size) {//不能右移时候挑战最小窗口大小，更新最小窗口开始的start
                    size = r - l + 1;
                    start = l;//记录下最小值时候的开始位置，最后返回覆盖串时候会用到
                }
                //移动了左指针，将左指针对应的字符所需要的次数+1
                need[s.charAt(l)]++;
                //重新维护左边界值和当前所需字符的值count
                l++;
                count++;

            }
            r++;

        }
        return size == Integer.MAX_VALUE ? "" : s.substring(start, start + size);
    }
}


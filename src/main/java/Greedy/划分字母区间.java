package Greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kai
 * @date 2022/2/17 下午8:33
 */
/*
字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。

输入：S = "ababcbacadefegdehijhklij"
输出：[9,7,8]
解释：
划分结果为 "ababcbaca", "defegde", "hijhklij"。
每个字母最多出现在一个片段中。
像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 */
public class 划分字母区间 {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> list = partitionLabels(s);
        System.out.println(list);

    }

    public static List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        //记录字符串中所有字符最后一次出现的下标
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> list = new ArrayList();
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                list.add(end - start + 1);//添加长度
                start = end + 1;
            }
        }
        return list;
    }
}

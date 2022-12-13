package LeetCodeHot100;

import java.util.*;

/**
 * @author kai
 * @date 2022/7/14 下午5:48
 */
/*
给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。

输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
输出: [["bat"],["nat","tan"],["ate","eat","tea"]]

输入: strs = [""]
输出: [[""]]

输入: strs = ["a"]
输出: [["a"]]
 */
public class _49字母异位词分组 {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            //字符数组转字符串
            String key = new String(array);//排好序为key：aet

            List<String> list;
            //存在key 返回value【list<String>】
            if (map.containsKey(key)) {
                list = map.get(key);
            } else {//不存在 返回 新建一个list new ArrayList()
                list = new ArrayList<>();
            }
            list.add(str);//放入 没排序的 str
            map.put(key, list);
        }

        return new ArrayList<List<String>>(map.values());
    }
}


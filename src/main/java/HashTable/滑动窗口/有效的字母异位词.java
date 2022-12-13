package HashTable.滑动窗口;

import java.util.HashMap;

/**
 * @author kai
 * @date 2022/1/14 上午10:50
 */
/*
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。

输入: s = "anagram", t = "nagaram"
输出: true

输入: s = "rat", t = "car"
输出: false
 */
public class 有效的字母异位词 {

    public static boolean isAnagram(String s, String t) {
        int[] record = new int[26];     //默认没有赋值都为0 record[0]=record[1]=record[2]=...=0
        for (char c : s.toCharArray()) {//遍历完字符串中所有字符
            //c代表的是s中的字符 假设是'a',c - 'a'=0 用数组record记录,record[0]=0+1 记录字符出现的次数
            record[c - 'a'] += 1;

        }
        for (char c : t.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            if ((map.get(s.charAt(i)) != null)) {//如果map中存在这个字符
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
            if (map.get(t.charAt(i)) != null) {
                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
            } else {
                map.put(t.charAt(i), -1);
            }
        }
        for (char c : map.keySet()) {//Map对象中keySet()方法获取所有的key值 键的值
            if (map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }
}

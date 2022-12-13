//package HashTable;
//
//import java.util.*;
//
///**
// * @author kai
// * @date 2022/1/14 下午6:46
// */
///*
//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
//字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
//
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//示例 2:
//
//输入: strs = [""]
//输出: [[""]]
//示例 3:
//
//输入: strs = ["a"]
//输出: [["a"]]
//
// */
//public class 字母异位词分组 {
//    public List<List<String>> groupAnagrams(String[] strs) {
//        if (strs.length == 0) {
//            return new ArrayList<>();
//        }
//        Map<String, List> map = new HashMap<>();
//        for (String s : strs) {
//            char[] chars = s.toCharArray();//字符串s先变成数组
//            Arrays.sort(chars);             //数组进行排序
//            String key = String.valueOf(chars);//再将数组chars变成排好序的字符串
//
//            if (!map.containsKey(key)) {//如果map不包含这样的键 将存储进map
//                map.put(key, new ArrayList());
//            } else {
//                map.get(key).add(s);//map通过key获取值，在值上再加满足要求的"s"字符串
//            }
//        }
//        Collection<List> values = map.values();
//        List<List<String>> lists = new ArrayList<>(values);
//        return lists;
//    }
//
//}

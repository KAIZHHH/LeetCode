package Array;

import java.util.*;

/**
 * @author kai
 * @date 2022/11/26 下午11:15
 */
/*
给定一个单词列表 words 和一个整数 k ，返回前 k 个出现次数最多的单词。
返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率， 按字典顺序 排序。

输入: words = ["i", "love", "leetcode", "i", "love", "coding"], k = 2
输出: ["i", "love"]
解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
    注意，按字母顺序 "i" 在 "love" 之前。


 */
public class 前K个高频单词 {
    public static void main(String[] args) {
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};

        List<String> strings = topKFrequent(words, 2);
        System.out.println(strings);
    }

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList();
        Map<String, Integer> map = new HashMap();
        for (String word : words) {
            if (!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        Object[][] objects = new Object[map.size()][2];
        int index = 0;
        for (String str : map.keySet()) {
            objects[index][0] = str;
            objects[index++][1] = map.get(str);
        }
        Arrays.sort(objects, (a, b) -> (int) b[1] - (int) a[1]);
        for (int i = 0; i < k; i++) {
            res.add((String) objects[i][0]);
        }
        return res;
    }
}

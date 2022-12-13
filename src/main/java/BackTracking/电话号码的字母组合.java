package BackTracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kai
 * @date 2022/2/11 上午12:51
 */
/*
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
1 不对应任何字母
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

输入：digits = ""
输出：[]

输入：digits = "2"
输出：["a","b","c"]
 */
public class 电话号码的字母组合 {
    static List<String> res = new ArrayList<>();
    static List<Character> path = new ArrayList<>();
    static Map<Character, String> map = new HashMap<>();

    public static void main(String[] args) {
        String digits = "23";
        List<String> strings = letterCombinations(digits);
        System.out.println(strings);

    }


    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return res;
        }

        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(digits, 0);
        return res;
    }

    public static void dfs(String digits, int start) {
        if (path.size() == digits.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                sb.append(path.get(i));
            }
            res.add(sb.toString());
            return;
        }
        char c = digits.charAt(start);
        String s = map.get(c);
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            path.add(c1);
            dfs(digits, start + 1);
            path.remove(path.size() - 1);
        }
    }

}

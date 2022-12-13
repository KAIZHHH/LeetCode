package LeetCodeHot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kai
 * @date 2022/7/2 上午1:45
 */
/*
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

输入：digits = ""
输出：[]
示例 3：

输入：digits = "2"
输出：["a","b","c"]
 */
public class _17电话号码的字母组合 {
    static List<String> result = new ArrayList();
    static List<Character> path = new ArrayList();
    static Map<Character, String> map = new HashMap();

    public static void main(String[] args) {
        String str = "23";
        List<String> strings = letterCombinations(str);
        System.out.println(strings);

    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return result;
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
        return result;
    }

    public static void dfs(String digits, int start) {
        if (path.size() == digits.length()) {
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < path.size(); i++) {
                Character character = path.get(i);
                sb.append(character);

            }
            result.add(sb.toString());
            return;
        }
        char c = digits.charAt(start);//'2''3'
        String s = map.get(c);//"abc""def"
        for (int i = 0; i < s.length(); i++) {//遍历"abc" / "def" 的字符
            char c1 = s.charAt(i);//取一个  放到path中
            path.add(c1);//path 存放 数字转换后的字符
            dfs(digits, start + 1);//放完一个 dfs下一个：'3' "def"
            path.remove(path.size() - 1);
        }
    }

    public static void dfs1(String digits, int start) {
        if (digits.length() == path.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < path.size(); i++) {
                Character character = path.get(i);
                sb.append(character);
            }
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

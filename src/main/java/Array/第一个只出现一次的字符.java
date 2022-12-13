package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kai
 * @date 2022/11/23 下午4:34
 */
public class 第一个只出现一次的字符 {
    public static void main(String[] args) {
        String s = "acbhdsjfqawsx";
        char c = firstUniqChar1(s);
        System.out.println(c);
    }

    public static char firstUniqChar(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    public static char firstUniqChar1(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            count[c - 'a']++;
        }
        for (char c : chars) {
            if (count[c - 'a'] == 1) {
                return c;
            }
        }
        return ' ';
    }
}


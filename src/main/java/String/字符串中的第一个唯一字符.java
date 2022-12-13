package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kai
 * @date 2022/9/22 下午8:34
 */
/*
1. 编写一个方法，计算一个字符串中（只包含A-Z,a-z），第一个不重复的字符在当前字符串中的索引。

 */
public class 字符串中的第一个唯一字符 {
    public static void main(String args[]) {
        String aString = "sabvbsaafss";
        int a = firstUniqChar(aString);
        System.out.println(a);
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); ++i) {
            if (frequency.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}

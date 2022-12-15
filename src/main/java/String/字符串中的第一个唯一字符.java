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
        String aString = "sabvbsaaf";
        int a = firstUniqChar1(aString);
        System.out.println(a);
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        //遍历字符串 判断是否个数是1
        for (int i = 0; i < s.length(); ++i) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    /*API
    indexOf(int ch): 返回指定字符在字符串中第一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
    lastIndexOf(int ch): 返回指定字符在此字符串中最后一次出现处的索引，如果此字符串中没有这样的字符，则返回 -1。
    一个是查字符第一次出现的，一个是查字符最后一次出现的，当二者下标重叠，那么该字符就是字符串中第一个唯一的字符。返回当前下标位置。下面是代码的实现
     */
    public static int firstUniqChar1(String s) {
        //按照字符串顺序 查找比较 ->第一个
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

}

package 笔试.欧科;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String pattern = "abba";
        String str = "dog cat cat dog";
        boolean b = wordPattern(pattern, str);
        System.out.println(b);
    }

    public static boolean wordPattern(String pattern, String str) {
        Map<Character, String> patoStr = new HashMap<>();
        Map<String, Character> strtoPa = new HashMap<>();
        String[] strs = str.split(" ");
        boolean flag = true;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String s = strs[i];

            if (!patoStr.containsKey(c)) {
                patoStr.put(c, s);
            } else if (!patoStr.get(c).equals(s)) {
                flag = false;
                break;
            }
            if (!strtoPa.containsKey(s)) {
                strtoPa.put(s, c);
            } else if (!strtoPa.get(s).equals(c)) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}

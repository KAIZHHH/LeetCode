package 笔试.科大讯飞;


import java.util.HashMap;
import java.util.Map;

/**
 * @author kai
 * @date 2022/8/10 下午1:26
 */
public class Test {
    public static void main(String[] args) {
        String s = "aabdcdnma";
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (char c : map.keySet()) {
            if (map.get(c) == 1) {
                System.out.println(c);
                return;
            }
        }
    }

    public static void test() {
        String s = "aabdcdnma";
        int[] arr = new int[26];

        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == 1) {
                char c = (char) (i + 'a');
                System.out.println(c);
                return;
            }

        }
    }

}

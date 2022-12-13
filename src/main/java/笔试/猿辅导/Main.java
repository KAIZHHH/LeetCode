package 笔试.猿辅导;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author kai
 * @date 2022/8/7 下午7:37
 */
/*
输入
复制
2
eyaobjcbcbioay
2
bob boy
mkijnebhuygv
1
make
输出
复制
2
0
说明
第一组：
对于“bob”， 给定字母卡片中有3个“b”，2个“o”， 能拼成1个“bob“；
对于“boy”，给定字母卡片中有3个“b”，2个““o”， 2个“y“，能拼成2个“boy“；
因此选择“boy”，最多能拼成的单词数为2。 第二组：
对于单词“make“，因为缺少字符“a“，所以能拼成的单 词个数为0。
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            int k = Integer.valueOf(sc.nextLine());
            String[] s = sc.nextLine().split(" ");
            int test = test(str, k, s);
            System.out.println(test);
        }
    }

    private static int test(String str, int k, String[] s) {
        int arr[] = new int[26];
        Map<Character, Integer> map = new HashMap<>();

        int n = str.length();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        Map<Character, Integer> test;
        int ans = 0;
        for (int i = 0; i < k; i++) {
            test = map;
            Map<Character, Integer> map1 = new HashMap<>();
            String s1 = s[i];
            //统计
            for (int j = 0; j < s1.length(); j++) {
                char c = s1.charAt(j);
                if (!map1.containsKey(c)) {
                    map1.put(c, 1);
                } else {
                    map1.put(c, map1.get(c) + 1);
                }
            }

            //比较
            int count = 0;
            int res = Integer.MAX_VALUE;
            for (char c : map1.keySet()) {
                int need = map1.get(c);
                if (test.containsKey(c) && test.get(c) >= need) {
                    count = test.get(c) / need;
                    res = Math.min(res, count);

                } else {
                    break;
                }
            }
            ans = Math.max(res, ans);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}

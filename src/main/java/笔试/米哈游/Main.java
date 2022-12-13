package 笔试.米哈游;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author kai
 * @date 2022/9/14 下午8:08
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        String str = sc.nextLine();
        int[] test = test(str, k);
        System.out.println(test);


    }

    private static int[] test(String str, int k) {
        Map<Character, Integer> needmap = new HashMap<>();
        needmap.put('m', k);
        needmap.put('i', k);
        needmap.put('h', k);
        needmap.put('y', k);
        needmap.put('o', 2 * k);
        int l = 0;

        int r = 0;
        int len = Integer.MAX_VALUE;
        int end = 0;
      a:  while (r < str.length()) {
            if (needmap.containsKey(str.charAt(r))) {
                needmap.put(str.charAt(r), needmap.get(str.charAt(r)) - 1);
            } else {
                r++;
                break a;
            }
            for (int i = 0; i < needmap.size(); i++) {
                if (needmap.get(str.charAt(i)) != 0) {
                    break a;
                }
            }
            if (len > r - l + 1) {
                len = Math.min(len, r - l + 1);
                end = r;
            }
            l++;
        }
        return new int[]{r - len, r};

    }
}

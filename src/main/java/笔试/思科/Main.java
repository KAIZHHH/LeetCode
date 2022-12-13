package 笔试.思科;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author kai
 * @date 2022/9/20 下午7:14
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(" ");

        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        int[] arr = new int[n];
        String s = sc.nextLine();
        String replace = s.replace(" ", "");
        String test = test(n, m, replace);
        System.out.println(test);
    }

    private static String test(int n, int m, String str) {
        StringBuilder sb = new StringBuilder(str);
        char[] res = new char[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int i1 = str.charAt(i) - '0';
            map.put(i1, i);
        }
        boolean flag = true;

        while (sb.length() > 0) {
            char[] chars = sb.toString().toCharArray();
            Arrays.sort(chars);
            int i = chars[chars.length - 1] - '0';

            int pos = map.get(i);
            if (flag) {
                res[pos] = 'A';


                for (int j = 0; j < m; j++) {
                    int val1 = sb.charAt(pos + 1) - '0';//5
                    int pos1 = map.get(val1);
                    res[pos1] = 'A';

                    int val2 = sb.charAt(pos - 1) - '0';//5
                    int pos2 = map.get(val2);
                    res[pos2] = 'A';
                }
                flag = false;
            } else {

                res[pos] = 'B';
                for (int j = 0; j < m; j++) {
                    int val1 = sb.charAt(pos + j) - '0';//5
                    int pos1 = map.get(val1);
                    res[pos1] = 'B';

                    int val2 = sb.charAt(pos - 1) - '0';//5
                    int pos2 = map.get(val2);
                    res[pos2] = 'B';
                }

                flag = true;
            }
            sb.delete(pos - m, pos + m + 1);
        }
        return res.toString();
    }

}

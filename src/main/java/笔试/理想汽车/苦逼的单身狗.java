package 笔试.理想汽车;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/6/12 下午1:44
 */
public class 苦逼的单身狗 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        while (m-- > 0) {
            String s = sc.next();
            int n = s.length();
            long res = 0;
            int l = -1, o = -1, v = -1, e = -1;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if (c == 'L') {
                    l = i;
                } else if (c == 'O') {
                    o = i;
                } else if (c == 'V') {
                    v = i;
                } else if (c == 'E') {
                    e = i;
                }
                int t = Math.min(Math.min(l, o), Math.min(v, e));
                if (t != -1) {
                    res += t + 1;
                }
            }
            System.out.println(res);
        }
    }
}

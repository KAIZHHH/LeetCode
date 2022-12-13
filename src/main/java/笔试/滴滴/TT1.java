package 笔试.滴滴;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/9/17 下午3:28
 */
public class TT1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        String[] s = test(target).split(" ");
        int n = s.length;
        System.out.println(n);
        for (int i = 0; i < n; i++) {
            System.out.print(s[i] + " ");
        }
    }

    private static String test(int target) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 1000000; i++) {
            int res = countNum(i) * i;

            if (res == target) {
                sb.append(i);
               sb.append(" ");
            }

        }
        return sb.toString();
    }

    private static int countNum(int i) {
        int res = 0;
        while (i != 0) {
            res++;
            i = i & (i - 1);
        }
        return res;
    }


}

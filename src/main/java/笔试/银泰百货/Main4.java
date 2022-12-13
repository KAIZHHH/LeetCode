package 笔试.银泰百货;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/9/23 下午7:14
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A = sc.next();
        String B = sc.next();
        int res = 0;
        for (int i = 0; i <= A.length(); i++) {
            StringBuilder sb = new StringBuilder(A);
            sb.insert(i, B);
            if (isValid(sb.toString())) res++;
        }
        System.out.println(res);
    }

    private static boolean isValid(String str) {
        int l = 0;
        int r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) return false;
        }
        return true;
    }
}

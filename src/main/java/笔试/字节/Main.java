package 笔试.字节;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/8/21 下午7:06
 */
/*
1
4 0
1010

 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < group; i++) {
            String[] s1 = sc.nextLine().split(" ");
            int n = Integer.valueOf(s1[0]);
            int k = Integer.valueOf(s1[1]);

            String s = sc.nextLine();
            int test = test(n, k, s);
            System.out.println(test);
        }
    }

    private static int test(int n, int k, String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                if (s.charAt(i + 1) == '0') {
//                    交换
                    sb.replace(i, i + 1, s.charAt(i + 1) + "");
                    sb.replace(i + 1, i + 2, s.charAt(i) + "");
                    k--;
                    if (k == 0) break;
                }
                if (s.charAt(i - 1) == '0') {
//                    交换
                    sb.replace(i, i + 1, s.charAt(i - 1) + "");
                    sb.replace(i - 1, i, s.charAt(i) + "");
                    k--;
                    if (k == 0) break;
                }
            }
        }

        String string = sb.toString();
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            String content = string.substring(i, i + 2);
            int num = Integer.valueOf(content);
            sum += num;
        }
        return sum;

    }
}

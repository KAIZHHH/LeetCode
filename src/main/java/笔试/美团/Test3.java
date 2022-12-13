package 笔试.美团;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/5/14 上午10:44
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int n = Integer.valueOf(s[0]);
        int k = Integer.valueOf(s[1]);

        String str = sc.nextLine();
        int test = test(str, n, k);
        System.out.println(test);

    }

    public static int test(String str, int n, int k) {
        int[] dp = new int[n];
        int res;
        int begin = k;

        for (int i = 0; i < n; i++) {
            begin = k;
            res = 0;

            for (int j = i + 1; j < n; j++) {
                if (str.charAt(j - 1) == '+') {
                    res++;
                } else {//-
                    begin--;
                    if (begin < 0) {
                        break;
                    }
                    res++;

                }
                dp[j] = Math.max(res, dp[j]);
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}

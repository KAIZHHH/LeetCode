package 笔试.牛客;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int test = test(s1, s2);
        System.out.println(test);
    }

    public static int test(String S, String T) {
        if (T.length() > S.length()) return 0;
        int m = S.length();
        int n = T.length();

        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = 0;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = n; j > 0; j--) {
                if (S.charAt(i - 1) == T.charAt(j - 1))
                    dp[j] = dp[j - 1] + dp[j];
            }
        }
        return dp[n];
    }
}

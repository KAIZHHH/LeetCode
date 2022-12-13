package 笔试.京东;

import java.util.Scanner;

/*
题目描述：
Alice需要用n块相同的大小为1*k的方形地砖铺满一块大小为n*k的地板。
她数学不是很好，所以希望你帮她计算有多少种不同的铺法。
          n 个 1&k n*k
如下图，使用5块大小为1*3的方形地砖铺满一块大小为5*3的地板总共有四种铺法。
输入仅包含一行，这行仅包含两个数n(1<=n<=10000)，k(1<=k<=1000)，代表题目中的参数。
输出所求的答案。因为答案可能很大，你只需要输出答案除以998244353所得的余数。
 */
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int dp[] = new int[n + 1];
        for (int i = 0; i < k; i++) {
            dp[i] = 1;
        }
        // dp[k] = 1;
        for (int i = k; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - k]) % 998244353;
        }
        System.out.println(dp[n]);
    }


}

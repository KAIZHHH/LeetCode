package 笔试.达达;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author kai
 * @date 2022/9/3 下午4:44
 */
/*
夏天燥热的傍晚，广场上有好多活动，其中有一个抽数字活动， 规则是在奖池内抽取任意次数的卡片，凑齐老板规定的数字就可
中奖。设奖池内的卡片面额类型有N种，1<N<10000，卡片数量
不限，第ⅰ种卡片面额为X，计算出黑心老板设置数字为多少可
以保证顾客永远不会中奖，将所有可设置的数字进行输出；若老
板可设置的数字是无限多个，直接输出XXX。如奖池内有3种面
额数字，面额分别为8，11，23，那老板可设置永远不可中奖的数 字为1234567910121314151718202125262829 3637：如奖池内有3种面额数字，面额分别为2，4，8，那老板可
设置的数字即为无限多个，直接输出XXX。

输入
2 3 5

输出
1
2 4
7

 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10000; i++) {
            if (!isValid(arr, i)) {
                list.add(i);
            }
        }
        if (list.size() > 5000) {
            System.out.println("XXX");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }


    public static boolean isValid(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == amount + 1 ? false : true;
    }
}

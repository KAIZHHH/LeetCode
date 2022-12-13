package 笔试.广联达;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/8/31 下午10:33
 */
/*
最多的人
题目描述：
水平的列车上有n个座位，从左到右座位号为1,2,...,n。现在有m条规定，每条规定的形式如下：从座位l到座位r，不多于x个人乘坐。在满足所有规定的前提下，该列车最多能乘坐多少人？

输入描述
首先输入两个整数n,m（1≤,n,m≤10^5），表示有n个座位，有m个规定。 然后输入m行，每行三个整数l,r,x（1≤l≤r≤n,1≤x≤r-l+1），表示从座位l到座位r，不多于x个人乘坐。

输出描述
输出一个整数s，表示最多能乘坐s人。

样例输入
10 3
1 4 2
3 6 2
10 10 1
样例输出
8

提示
用1表示有人乘坐，0表示空位，一种最优的方式为1100111111，可以乘坐8人。
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        String[] s = new String[m];
        for (int i = 0; i < m; i++) {
            s[i] = sc.nextLine();
        }
        int test = test(n, m, s);
        System.out.println(test);
    }

    private static int test(int n, int m, String[] s) {
        int[][] arr = new int[m][3];
        for (int i = 0; i < m; i++) {
            String[] split = s[i].split(" ");
            arr[i][0] = Integer.parseInt(split[0]);
            arr[i][1] = Integer.parseInt(split[1]);
            arr[i][2] = Integer.parseInt(split[2]);
        }
        int sum = 0;
        for (int i = 1; i < m; i++) {
            if (arr[i - 1][1] < arr[i][0]) {
                int i1 = arr[i][0] - arr[i - 1][1] - 1;
                sum += i1;
            }
            sum += arr[i - 1][2];
        }
        sum += arr[arr.length - 1][2];
        if (n > arr[arr.length - 1][1]) {
            sum += n - arr[arr.length - 1][1];
        }
        return sum;
    }


}

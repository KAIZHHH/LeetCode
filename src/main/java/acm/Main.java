package acm;

import java.util.Scanner;

/*
* 输入描述
输入第一行包含一个正整数n，表示该员工这一天的打卡记录数量。(1<=n<=50)
接下来有n行，每行首先是一个字符串“in”或“out”，分别表示进入和出去。之后是一个时间表示“xx:yy:zz“，表示一个时刻，精确到秒。
输出描述
请你输出一个形如”xx:yy:zz”的字符串，表示该员工的工作时长。
样例输入
6
in 00:40:14
out 04:48:37
in 07:06:20
out 09:17:53
in 10:14:44
out 10:36:29
* */
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        StringBuilder res = new StringBuilder();
        int sumsurplus = 0;
        for (int i = 1; i <= (n / 2); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("in").append(" ").append(scan.next());

            int hourIn = Integer.parseInt(sb.substring(3, 5));
            int minIn = Integer.parseInt(sb.substring(6, 8));
            int secondIn = Integer.parseInt(sb.substring(9, sb.toString().length()));
            int sumSecondIn = hourIn * 60 * 60 + minIn * 60 + secondIn;
            StringBuilder sb1 = new StringBuilder();
            sb1.append("out").append(" ").append(scan.next());

            int hourOut = Integer.parseInt(sb1.substring(4, 6));
            int minOut = Integer.parseInt(sb1.substring(7, 9));
            int secondOut = Integer.parseInt(sb1.substring(10, sb1.toString().length()));
            int sumSecondOut = hourOut * 60 * 60 + minOut * 60 + secondOut;
            sumsurplus += sumSecondOut - sumSecondIn;
        }
        int resHour = sumsurplus / 3600;
        int resMin = sumsurplus % 3600 / 60;
        int resSecond = sumsurplus / 3600 % 60;
        System.out.println(resHour + ":" + resMin + ":" + resSecond);
    }
}

package 笔试.腾讯;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/4/24 下午9:14
 */
/*
给一堆字符串代表一排士兵，士兵编号1~n，字符串中‘0’的士兵代表进攻性的，
‘1’的代表防御性的，每个士兵的攻击力或守备力为其下标值。将士兵分组，0~pos的是进攻组，
只算攻击力，pos+1~n的是防御组，只算防御力。pos可以取0~n。
求攻击组的攻击力和防御组的防御力的差的绝对值的最小值。
思路：使用前缀和记录攻击力和防御力，并逐一求差值的绝对值的最小值。

 */
public class 士兵攻击和防御差最小值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = Integer.valueOf(s);
        int[] nums = new int[n];
        String str = sc.nextLine();
        int res = test(str);
        System.out.println(res);
    }

    public static int test(String str) {
        int res = Integer.MAX_VALUE;
        int min = 0;
        int k = 0;
        for (int i = 1; i < str.length(); i++) {
            String s1 = str.substring(0, i);
            int[] count1 = count(s1, 0);
            int attack1 = count1[0];
            int defend1 = count1[1];

            String s2 = str.substring(i, str.length());
            k = s1.length();
            int[] count2 = count(s2, k);
            int attack2 = count2[0];
            int defend2 = count2[1];
            int res1 = Math.abs(attack1 - defend2);
            res = Math.min(res, res1);
        }
        return res;
    }

    public static int[] count(String str, int k) {
        int attack = 0;
        int defend = 0;
        int[] int1 = new int[2];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                attack += k + i + 1;
            } else {//1
                defend += k + i + 1;
            }
        }
        int1[0] = attack;
        int1[1] = defend;
        return int1;
    }

}

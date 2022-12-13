package 笔试.腾讯;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/4/18 上午11:20
 */
/*
给定一个字符串，问是否能够通过添加一个字母将其变成“回文串”。
“回文串”是指正着和反着读都一样的字符串。如：”aa”，"bob”，"testset'"是回文串，”aice”，”time”都不是回文串。
 */
public class 添加字符验证回文串 {
    public static void main(String[] args) {
        boolean res = false;
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb;
        a:
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);//用来插入比较 是否符合
            b:
            for (int j = i; j <= str.length(); j++) {
                sb = new StringBuilder(str);
                StringBuilder insert = sb.insert(j, ch);
                res = test(insert);

                if (res == true) {
                    break a;
                }
            }
        }
        if (res == true) {
            System.out.println("true");
        } else {
            System.out.println("false");

        }

    }

    public static boolean test(StringBuilder str) {
        String s = str.toString();
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length() / 2; i++) {
            if (chars[i] != chars[s.length() - 1 - i]) {
                return false;
            }

        }
        return true;
    }
}

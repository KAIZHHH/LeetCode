package 笔试.绿盟;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/8/28 下午8:13
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (char c : next.toCharArray()) {
            if (Character.isLetter(c) || c == ' ') {
                sb.append(c);
            }
        }
        String s = sb.toString();
        String[] s1 = s.split(" ");
        int n = s1.length;
        String[] s2 = new String[n];

        int end = n - 1;
        for (int i = 0; i < s1.length; i++) {
            s2[end--] = reverse(s1[i]);
        }
        StringBuilder sb1 = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb1.append(s2[i]);
            sb1.append(" ");
        }
        System.out.println(sb1.toString());

    }

    public static String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {//小写
                char c1 = (char) (c - 32);
                sb.append(c1);
            } else {//大写
                char c1 = (char) (c + 32);
                sb.append(c1);
            }
        }
        return sb.toString();
    }
}

package 笔试.银泰百货;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/9/23 下午7:27
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String test = test(str);
        System.out.println(test);
    }

    private static String test(String str) {
        StringBuilder sb = new StringBuilder();
        int n = str.length();
        for (char c : str.toCharArray()) {
            if (c - '0' >= 0 && c - '0' <= 9) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}

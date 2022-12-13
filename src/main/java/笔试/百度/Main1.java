package 笔试.百度;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/9/13 下午7:37
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int test = test(str);
        System.out.println(test);
    }

    private static int test(String str) {
        int res = 0;
        int n = str.length();
        for (int i = 0; i < n - 5; i++) {
            String substring = str.substring(i, i + 5);
            if (isValid(substring)) res++;
        }
        return res;
    }

    private static boolean isValid(String str) {
        int[] arr = new int[128];
        char c1 = str.charAt(0);
        char c2 = str.charAt(1);
        char c3 = str.charAt(2);
        char c4 = str.charAt(3);
        char c5 = str.charAt(4);
        for (int i = 0; i < 5; i++) {
            char c = str.charAt(i);
            arr[c - 'a']++;
        }
        for (int i = 0; i < 128; i++) {
            if (arr[i] >= 2) return false;
        }
        if (isValid(c1) == false && isValid(c2) == true && isValid(c3) == true && isValid(c4) == false && isValid(c5) == true) {
            return true;
        }
        return false;
    }

    //元音
    private static boolean isValid(char c) {
        if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
        return false;
    }
}

package 笔试.量锐;

import java.util.Scanner;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author kai
 * @date 2022/12/6 下午7:10
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        String test = test(next);
        System.out.println(test);
    }


    public static String test(String str) {
        String res = "";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '_') {
                chars[i + 1] -= 32;
            } else {
                res += chars[i];
            }
        }
        return res;
    }
}

package 笔试.字节;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/8/22 下午2:25
 */
public class Main1 {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < group; i++) {
            String[] s1 = sc.nextLine().split(" ");
            int n = Integer.valueOf(s1[0]);
            int k = Integer.valueOf(s1[1]);

            String s = sc.nextLine();
            char[] chars = s.toCharArray();

            if (k == 0) {
                System.out.println(getRes(chars));
            } else {
                dfs(chars, 0, k);
                System.out.println(getRes(chars));
            }
        }
    }

    private static void dfs(char[] chars, int start, int k) {
        if (k == 0) {
            min = Math.min(min, getRes(chars));
            return;
        }
        for (int j = start; j < chars.length - 1; j++) {
            if (chars[j] != chars[j + 1]) {
                swap(chars, j, j + 1);
                dfs(chars, j + 1, k - 1);
                swap(chars, j, j + 1);

            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;

    }

    private static int getRes(char[] chars) {
        int sum = 0;
        for (int i = 1; i < chars.length; i++) {
            String s = String.valueOf(chars[i - 1]) + String.valueOf(chars[i]);
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}

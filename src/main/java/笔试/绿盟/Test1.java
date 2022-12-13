package 笔试.绿盟;

import java.util.Scanner;

/**
 * @author kai
 * @date 2022/8/28 下午7:59
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        String replace = s.replace("[", "");
        String replace1 = replace.replace("]", "");
        String[] split = replace1.split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        int test = test(arr);
        System.out.println(test);
    }

    private static int test(int[] arr) {
        int[] res = new int[100];
        for (int i : arr) {
            res[i]++;
        }
        int n = arr.length;
        for (int i = 0; i < res.length; i++) {
            if (res[i] > n / 2) {
                return i;
            }
        }
        return 0;
    }
}

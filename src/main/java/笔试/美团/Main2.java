package 笔试.美团;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author kai
 * @date 2022/8/13 下午4:48
 */
public class Main2 {
    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        int[] arr = new int[n];
        String[] s = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.valueOf(s[i]);
        }
        test(arr);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
    }

    private static void test(int[] arr) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            list.addFirst(arr[i]);
            if (list.size() >= 2) {
                int num = list.peekLast();
                list.removeLast();
                list.addFirst(num);

                int num1 = list.peekLast();
                list.removeLast();
                list.addFirst(num1);
            }
        }

    }
}

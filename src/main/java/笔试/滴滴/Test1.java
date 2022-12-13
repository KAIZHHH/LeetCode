package 笔试.滴滴;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author kai
 * @date 2022/6/11 下午7:25
 */
public class Test1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        for (int i = 0; i < n; i++) {
            int len = Integer.valueOf(sc.nextLine());
            int arr[] = new int[len];
            String[] s = sc.nextLine().split(" ");
            for (int j = 0; j < len; j++) {
                arr[j] = Integer.valueOf(s[j]);
            }
            boolean test = test(arr);
            if (test) {
                System.out.println("Yes");
            } else {
                System.out.println("No");

            }
        }
    }

    public static boolean test(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            if (planA(arr, i)) return true;
            if (planB(arr, i)) return true;
        }
        return false;
    }


    public static boolean planA(int[] arr, int i) {
        int n = arr.length;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(arr[0]);
        int head = arr[0];

        for (int j = i; j < n; j++) {
            if (head <= arr[j]) {
                list1.add(arr[j]);
                head = arr[j];
            } else {
                list2.add(arr[j]);
            }
        }
        if (list2.size() <= 1) {
            return true;
        } else {
            int header = list2.get(0);
            for (int j = 1; j < list2.size(); j++) {
                if (header >= list2.get(j)) {
                    return false;
                }
                header = list2.get(j);

            }
        }

        return true;
    }


    public static boolean planB(int[] arr, int i) {
        int n = arr.length;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(arr[0]);
        int head = arr[0];

        for (int j = i; j < n; j++) {
            if (head >= arr[j]) {
                list1.add(arr[j]);
                head = arr[j];
            } else {
                list2.add(arr[j]);
            }
        }
        if (list2.size() <= 1) {
            return true;
        } else {
            int header = list2.get(0);
            for (int j = 1; j < list2.size(); j++) {
                if (header >= list2.get(j)) {
                    return false;
                }
                header = list2.get(j);

            }
        }

        return true;
    }


}

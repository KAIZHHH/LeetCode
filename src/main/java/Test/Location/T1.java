package Test.Location;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/9/5 下午1:32
 */
public class T1 {
    public static void main(String[] args) {
        int a = 1;
        String s = "123";
        int[] array = new int[]{1};
        changeInt(a);
        String s1 = changeString(s);
        System.out.println(s1);
        changeArray(array);
        System.out.println(a + " " + s + " " + Arrays.toString(array));
    }

    private static void changeInt(int a) {
        a = 2;
    }

    private static String changeString(String s) {
//        s += "4";
        s = "4"; //都不变
        return s;
    }

    private static void changeArray(int[] arr) {
        arr[0] = -2;
    }
}

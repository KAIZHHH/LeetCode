package Array;

/**
 * @author kai
 * @date 2022/11/23 下午4:25
 */
public class 找出数组中第二大的数 {
    public static void main(String[] args) {
        int[] a = {1, 3, 2, 4, 6, 5, 1};
        int test = test(a);
        System.out.println(test);
    }

    public static int test(int[] a) {
        int max = a[0];
        int sec = Integer.MIN_VALUE;
        for (int i = 1; i < a.length; i++) {
//       第i个元素a[i] > max >sec
            if (a[i] > max) {
                sec = max;
                max = a[i];
//          第i个元素小于max但是大于sec
            } else if (a[i] > sec) {
                sec = a[i];
            }
        }
        return sec;
    }
}

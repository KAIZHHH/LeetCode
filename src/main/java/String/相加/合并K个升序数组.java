package String.相加;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author kai
 * @date 2022/5/18 下午12:24
 */

public class 合并K个升序数组 {
    public static void main(String[] args) {
        List<int[]> ints = new ArrayList<>();
        ints.add(new int[]{1, 4, 6});
        ints.add(new int[]{1, 2, 3});
        ints.add(new int[]{5, 6, 7});
        int[] res = mergeKInts(ints);
        System.out.println(Arrays.toString(res));
    }

    public static int[] mergeKInts(List<int[]> ints) {
        int[] num = new int[0];
        for (int[] k : ints) {
            num = merge(num, k);
        }
        return num;
    }

    public static int[] merge(int[] m, int[] n) {
        int a = m.length - 1;
        int b = n.length - 1;
        int[] res = new int[m.length + n.length];
        int k = res.length - 1;
        while (a >= 0 && b >= 0) {
            if (m[a] > n[b]) {
                res[k--] = m[a--];
            } else {
                res[k--] = n[b--];
            }
        }

        while (a >= 0) {
            res[k--] = m[a--];
        }

        while (b >= 0) {
            res[k--] = n[b--];
        }
        return res;
    }
}

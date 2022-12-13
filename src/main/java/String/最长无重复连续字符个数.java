package String;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kai
 * @date 2022/9/9 下午8:39
 */
/*
给定一个长度为n的数组arr，返回arr的最长无重复元素子数组的长 度，无重复指的是所有数字都不相同。
子数组是连续的，比如[1，3，5，7，9]的子数组有[1，3]，[3，5，7]等等，但 是[1，3，7]不是子数组
 */

/*
[2,3,4,5] 4
[2,2,3,4,3] 3
[1,2,3,1,2,3,2,2] 3
 */

public class 最长无重复连续字符个数 {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 2, 3, 4, 3};
        int i = maxLength(arr);
        System.out.println(i);
    }

    public static int maxLength(int[] arr) {
        int n = arr.length;
        Set<Integer> set = new HashSet();
        int l = 0;
        int r = 0;
        int res = 0;
        while (r < n) {
            if (set.contains(arr[r])) {
                set.remove(arr[l++]);
            } else {
                set.add(arr[r++]);
            }
            res = Math.max(res, set.size());
        }
        return res;
    }
}

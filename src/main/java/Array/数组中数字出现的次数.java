package Array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @Description
 * @Author huangkai.zhong
 * @Data 2022/12/14 11:32 AM
 */
/*
一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]

输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]
 */
public class 数组中数字出现的次数 {
    public static void main(String[] args) {
        int[] nums = {4, 1, 4, 6};
        Integer[] integers = singleNumber(nums);
        System.out.println(Arrays.toString(integers));
    }

    public static Integer[] singleNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
            } else {
                set.remove(i);
            }
        }
        Integer[] integers = set.toArray(new Integer[set.size()]);
        return integers;
    }
}
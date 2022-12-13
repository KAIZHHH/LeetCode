package HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kai
 * @date 2022/1/19 上午12:03
 */
/*
给定两个数组，编写一个函数来计算它们的交集。

输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]
示例 2：

输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]

 */
public class 两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
//        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) {
//            return new int[0];
//        }
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> reSet = new HashSet<>();
        //去重
        for (int i : nums1) {
            set1.add(i);
        }

        //做交集
        for (int i : nums2) {
            if (set1.contains(i)) {
                reSet.add(i);
            }
        }
        int[] ints = new int[reSet.size()];
        int index = 0;
        //把reSet去重做交集后的结果转成数组
        for (int i : reSet) {
            ints[index] = i;
            index++;
        }
        return ints;
    }


    //双重for
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> a = new HashSet();
        for (int num1 : nums1) {
            for (int i = 0; i < nums2.length; i++) {
                if (nums2[i] == num1) {
                    a.add(num1);
                }
            }
        }
        int[] res = new int[a.size()];
        int i = 0;
        for (int num : a) {
            res[i++] = num;
        }
        return res;
    }
}

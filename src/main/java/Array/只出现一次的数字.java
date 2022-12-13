package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kai
 * @date 2022/11/23 下午3:05
 */
/*
给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。

输入：nums = [2,2,1]
输出：1

输入：nums = [4,1,2,1,2]
输出：4

 */
public class 只出现一次的数字 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3, 2, 5};
        int i = singleNumber2(arr);
        System.out.println(i);
    }

    public static int singleNumber(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>(arr.length);
        for (int i : arr) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                map.put(i, map.get(i) + 1);
            }
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1; // can't find it.

    }

    public static int singleNumber2(int[] nums) {

        int[] count = new int[10];
        for (int i : nums) {
            count[i]++;
        }
        for (int i : nums) {
            if (count[i] == 1) {
                return i;
            }
        }
        return ' ';
    }

    public int singleNumber1(int[] nums) {
        int single = 0;
        for (int num : nums) {
            single ^= num;
        }
        return single;
    }


}

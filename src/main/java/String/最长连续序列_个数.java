package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author kai
 * @date 2022/6/5 下午7:26
 */
/*
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。

输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
 */
public class 最长连续序列_个数 {
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int[] res = longestConsecutive2(nums);
        System.out.println(Arrays.toString(res));
    }


    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        //去重
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) continue;
            int len = 1;
            while (set.contains(num + 1)) {
                len++;
                num++;
            }
            res = Math.max(res, len);

        }
        return res;
    }

    public static int[] longestConsecutive2(int[] nums) {
        int[] ans = new int[2];
        Set<Integer> set = new HashSet();
        //去重
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        int end = nums[0];
        for (int num : nums) {
            if (set.contains(num - 1)) continue;
            int len = 1;
            while (set.contains(num + 1)) {
                len++;
                num++;
            }
            if (len >= res) {
                res = Math.max(res, len);
                end = num;
            }
        }
        ans[0] = end - res + 1;
        ans[1] = end;
        return ans;
    }
}


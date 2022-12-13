package Greedy;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/2/15 下午11:17
 */
/*
给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：

选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
以这种方式修改数组后，返回数组 可能的最大和 。

输入：nums = [4,2,3], k = 1
输出：5
解释：选择下标 1 ，nums 变为 [4,-2,3] 。

输入：nums = [3,-1,0,2], k = 3
输出：6
解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。

输入：nums = [2,-3,-1,5,-4], k = 2
输出：13
解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 */
public class K次取反后最大化的数组和 {
    public static void main(String[] args) {
        int[] nums = {2, -3, 1, 5, 4};
        int i = largestSumAfterKNegations(nums, 2);
        System.out.println(i);
    }

    public static int largestSumAfterKNegations(int[] nums, int k) {
        // 排序，把可能有的负数排到前面
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            // 贪心：如果是负数，而k次机会 调转，就把负数反过来
            if (nums[i] < 0 && k > 0) {
                nums[i] = -nums[i];
                k--;
            }
            sum += nums[i];
        }
        Arrays.sort(nums);
        //可能还有负数但是没办法 已经按照k的个数把最小的负数先转正了 此时sum已经是最大

        // 如果k有剩，说明负数已经全部转正，所以如果k还剩偶数个就自己抵消掉，不用删减，如果k还剩奇数个就减掉2倍最小正数。
        if (k > 0) {
            if (k % 2 != 0) {//不是偶数 是奇数
                sum -= 2 * nums[0];
            }
        }
//        if (k == 0) {// 如果k没剩，那说明能转的负数都转正了，已经是最大和，返回sum
//            return sum;
//        }
        return sum;
    }
}

package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author kai
 * @date 2022/1/19 下午6:46
 */
/*
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案。

输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：

输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：

输入：nums = [3,3], target = 6
输出：[0,1]
 */
public class 两数之和 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 1, 8};
        int[] res = twoSum2(nums, 9);
        System.out.println(Arrays.toString(res));

//        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;

    }

    public static int[] twoSum2(int[] arr, int target) {
        Arrays.sort(arr);
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            if (arr[l] + arr[r] < target) {
                l++;
            } else if (arr[l] + arr[r] > target) {
                r--;
            } else {
                return new int[]{arr[l], arr[r]};
            }
        }
        return null;
    }
}


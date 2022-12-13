package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kai
 * @date 2022/7/26 下午9:10
 */
/*
输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]
示例 2：

输入：nums = [10,26,30,31,47,60], target = 40
输出：[10,30] 或者 [30,10]

 */
public class 和为s的两个数字 {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (set.contains(target - nums[i])) {
                return new int[]{target - nums[i], nums[i]};
            }
            set.add(nums[i]);
        }
        return null;
    }

    public int[] twoSum1(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                return new int[]{nums[i], nums[j]};
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return new int[]{0, 0};
    }
}

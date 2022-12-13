package Array.二分查找;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author kai
 * @date 2022/11/23 下午1:56
 */
/*
给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。

输入：nums = [1,3,4,2,2]
输出：2

输入：nums = [3,1,3,4,2]
输出：3
 */
public class 寻找重复数 {
    //方法一：利用hashmap的方法，进行遍历数组，统计数字出现的次数
    //使用hashMap的方法：遍历整个数组，统计每个数字出现的次数
    public int findDuplicate1(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (Integer num : nums) {
            if (countMap.get(num) == null)
                countMap.put(num, 1);
            else
                return num;
        }
        return -1;
    }
    //    方法二：可以利用set进行保存，我们知道set集合是无序的且数据是不能够重复。

    public int findDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (Integer num : nums) {
            if (set.contains(num)) {
                return num;
            } else
                set.add(num);
        }
        return -1;

    }
/*
无论是方法一还是方法二，时间复杂度都是O（n），对数组进行了一次的遍历，查找的时间复杂度为O（1）。空间复杂度为O（n）。
需要一个外部的存储HashMap或者是HashSet进行做额外的存储，不太满足题目当中的要求。需要进行改进的。
 */

    public int findDuplicate3(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int cnt = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }

    public int findDuplicate4(int[] nums) {
        int l = 1;
        int r = nums.length - 1;
        // 二分查找
        while (l <= r) {
            int i = (l + r) / 2;
            // 对当前i计算count[i]
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i) {
                    count++;
                }
            }
            // 判断count[i]和i的大小关系
            if (count <= i) {
                l = i + 1;
            } else {
                r = i;
            }
            // 找到target
            if (l == r) {
                return l;
            }
        }
        return -1;
    }
}

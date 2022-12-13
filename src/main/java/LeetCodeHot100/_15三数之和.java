package LeetCodeHot100;

import java.util.*;

/**
 * @author kai
 * @date 2022/6/10 上午9:15
 */
/*
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
注意：答案中不可以包含重复的三元组。

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]

输入：nums = []
输出：[]

输入：nums = [0]
输出：[]
 */
public class _15三数之和 {
    static Set<List<Integer>> set = new HashSet<>();
    static List<Integer> path = new ArrayList();

    public static void main(String[] args) {
        int[] nums = {3, 0, -2, -1, 1, 2};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);

    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        if (n < 3) return new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int l = i + 1, r = n - 1; l <= r; l++, r--) {
                int y = nums[l];
                int z = nums[r];
                if (x + y + z == 0) {
                    path.add(x);
                    path.add(y);
                    path.add(z);
                    set.add(new ArrayList(path));
                    path = new ArrayList();
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        res.addAll(set);
        return res;
    }

    public List<List<Integer>> threeSum1(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);
                    set.add(list);
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }

        }
        List<List<Integer>> res = new ArrayList();
        res.addAll(set);
        return res;

    }
}

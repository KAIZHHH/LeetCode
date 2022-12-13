package HashTable;

import java.util.*;

/**
 * @author kai
 * @date 2022/6/19 下午1:30
 */
public class 三数之和 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        Set<List<Integer>> set = new HashSet();
        List<Integer> list = new ArrayList();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = nums[l] + nums[r] + nums[i];
                if (sum == 0) {
                    list.add(nums[l]);
                    list.add(nums[r]);
                    list.add(nums[i]);
                    set.add(list);
                    list = new ArrayList();
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        res.addAll(set);
        return res;

    }
}

package 笔试.途虎养车;

import java.util.*;

public class Test3 {
    public int minimumIncompatibility(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int size = len / k;
        Map<Integer, Integer> map = new HashMap<>();
        build(0, 0, nums, map, 0, len + 1, size, 0);
        int[] dp = new int[(1 << nums.length + 1)];
        Set<Integer> set = new HashSet<>();
        int[] ints = new int[set.size()];
        int i = 0;
        for (int n : set) {
            ints[i++] = n;
        }
        Arrays.fill(dp, -2);
        return dfs(0, (1 << len) - 1, ints, 0, dp, map);

    }

    public void build(int start, int pre, int[] nums, Map<Integer, Integer> map, int max, int min, int level, int stau) {
        if (level == 0) {
            map.put(stau, max - min);
            return;

        }
        for (int i = start; i < nums.length; i++) {
            if (nums[i] == pre) continue;
            build(i + 1, nums[i], nums, map, Math.max(max, nums[i]), Math.min(min, nums[i]), level - 1, (stau) | (1 << i));
        }

    }

    private int dfs(int used, int all, int[] arr, int index, int[] dp, Map<Integer, Integer> map) {
        if (used == all) return 0;
        if (dp[used] != -2) return dp[used];
        int a = Integer.MAX_VALUE;
        for (int i = index; i < arr.length; i++) {
            int dfs = dfs(arr[i] | used, all, arr, i + 1, dp, map);
            if (dfs != -1) a = Math.min(a, map.get(arr[i] + dfs));
        }
        dp[used] = (a == Integer.MAX_VALUE ? -1 : a);
        return dp[used];
    }

}

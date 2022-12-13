package Array;

import java.util.*;

/**
 * @author kai
 * @date 2022/8/3 下午11:52
 */
/*
给定一个单词列表 words 和一个整数 k，
返回前 k 个出现次数最多的单词。
返回的答案应该按单词出现频率由高到低排序。
如果不同的单词有相同出现频率， 按字典顺序 排序。



输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]
 */
public class 前K个高频元素 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] ints = topKFrequent(nums, 2);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        //用map存储：记录字符次数
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        //map转二维数组：方便排序
        int[][] res = new int[map.size()][2];
        int index = 0;
        for (int m : map.keySet()) {//拿出来的是key
            res[index][0] = m;
            res[index++][1] = map.get(m);
        }

        //根据value的大小排序(降序)就是大的在前
        Arrays.sort(res, (a, b) -> b[1] - a[1]);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = res[i][0];
        }
        return ans;
    }

    public static int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        //用map存储：记录字符次数
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();

        //排序map 根据value的大小排序(降序)就是大的在前
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        list.addAll(entries);
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = list.get(i).getKey();
        }
        return ans;
    }
}

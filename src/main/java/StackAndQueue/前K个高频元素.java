package StackAndQueue;

import java.util.*;

/**
 * @author kai
 * @date 2022/1/26 上午12:50
 */
/*
给你一个整数数组 nums 和一个整数 k ，
请你返回其中出现频率前 k 高的元素。
你可以按 任意顺序 返回答案。

输入: nums = [1,1,1,2,2,3], k = 2
输出: [1,2]
示例 2:

输入: nums = [1], k = 1
输出: [1]

 */
public class 前K个高频元素 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 4, 3, 3};

    }

    /*
如果a[0]比b[0]大，减出来的数就是一个正数 return 1，得到相当于 3 2 1 这样的排序，所以是降序
1 1
2 2
3 2
4 1
降序：
2 2
3 2
1 1
4 1

1 2 3 4 为第0列的所有行
1 2 2 1 为第1列的所有行
return a[0]-b[0] 就是对第0列的数据进行排序，a[0]可以理解成 1 ，b[0]可以理解成 3
return b[1]-a[1] 就是对第1列的数据进行排序
 */
    public int[] topKFrequent1(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        //记录次数
        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
//        for (int n : nums) {
//            map.put(n, map.getOrDefault(n, 0) + 1);
//        }
        //定义二维数组
        int[][] num = new int[map.size()][2];//l行2列

        //将map放入二维数组
        int m = 0;
        for (int j : map.keySet()) {
            num[m][0] = j;//记录出现的字符
            num[m][1] = map.get(j);//记录出现字符的次数
            m++;
        }

        //对二维数组排序
    /*
    降序：0 1
     0   2 2
     1   3 2
     2   1 1
     3   4 1
     */
        Arrays.sort(num, (a, b) -> b[1] - a[1]);//b-a降序 a-b按顺序就是升序
        int ans[] = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = num[i][0];
        }
        return ans;
    }

    public static int[] topKFrequent2(int[] nums, int k) {
        //记录次数
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //定义list集合存放每一个map(key,valiue)
        List<int[]> list = new ArrayList<>();
        //map放到list集合里
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            list.add(new int[]{key, value});
        }
        //对value降序
        list.sort((o1, o2) -> o2[1] - o1[1]);
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i)[0];
        }
        return result;
    }

}

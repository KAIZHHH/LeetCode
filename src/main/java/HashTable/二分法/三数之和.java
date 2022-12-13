package HashTable.二分法;

import java.util.*;

/**
 * @author kai
 * @date 2022/1/19 下午10:38
 */
/*
给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]

输入：nums = []
输出：[]

输入：nums = [0]
输出：[]
 */
public class 三数之和 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(nums);
        System.out.println(lists);
    }

    /**
     * 1、先排序
     * 2、定义声明
     * 3、创建头尾指针
     * 4、遍历所有数字
     * 5、比较sum和0大小
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        //先排序：方便使用二分法搜索
        Arrays.sort(nums);
        //不重复的三元组:用set
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            //二分法
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> list = Arrays.asList(nums[i], nums[left], nums[right]);//创建List集合添加元素：{nums[i], nums[left], nums[right]}
//                    List<Integer> list=new ArrayList<>();
//                    list.add(nums[i]);
//                    list.add(nums[left]);
//                    list.add(nums[right]);
                    res.add(list);//set集合res存放去重复的{},{}
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;

                } else {
                    right--;
                }
            }
        }
        //要求返回：List<List<Integer>> 再addAll 使返回的类型相同
        List<List<Integer>> ans = new ArrayList<>();//{     {Integer},{Integer},{Integer}    }
        ans.addAll(res);
        return ans;
    }


}

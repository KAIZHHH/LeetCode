package Array.双指针;

/**
 * @author kai
 * @date 2021/12/29 下午11:43
 */
/*
给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
不要使用额外的数组空间，你必须仅使用 $O(1)$ 额外空间并原地修改输入数组。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
示例 2: 给定 nums = [0,1,2,2,3,0,4,2], val = 2, 函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。
 */
public class 移除元素 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 2, 3};
        int val = 3;
        int i = remove(nums, val);
        //返回数组长度
        System.out.println(i);
    }

    public static int remove(int[] nums, int val) {
        int left = 0;//记录相等的数字 让下一次不相等的时候覆盖掉前面的
        int right = 0;
        while (right < nums.length) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                right++;
                left++;
            } else {
                //相等的话：left不走记录下标 等下个覆盖上去
                right++;
            }
        }
        return left;
    }

}

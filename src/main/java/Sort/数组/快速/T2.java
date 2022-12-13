package Sort.数组.快速;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/2/24 下午9:31
 */
public class T2 {

    public static void main(String[] args) {
        int[] arr = {10, 7, 2, 4, 7, 19};
        System.out.println(Arrays.toString(arr));

        test(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void test(int[] nums, int low, int high) {
        if (low >=high) {
            return;
        }
        int i = low;
        int j = high;
        int tem = nums[low];//不能是 nums[i] i每次循环都在改变
        while (i <j) {
            while (tem <= nums[j] && i < j) {
                j--;
            }
            while (tem >= nums[i] && i < j) {
                i++;
            }
            swap(nums, i, j);
        }
        //i=j退出
        nums[low] = nums[j];
        nums[j] = tem;
        //一次tem结束 以tem为中心 继续递归调用排序
        test(nums, low, j - 1);
        test(nums, j + 1, high);

    }

    public static void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}

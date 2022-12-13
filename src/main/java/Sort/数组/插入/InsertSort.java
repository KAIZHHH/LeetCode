package Sort.数组.插入;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/3 下午11:46
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int nums[] = {2, 6, 3, 8, 1, 5};
        System.out.println(Arrays.toString(nums));

        Insert(nums);
        System.out.println(Arrays.toString(nums));
    }


    public static void swap(int[] arr, int n1, int n2) {
        int temp = arr[n1];
        arr[n1] = arr[n2];
        arr[n2] = temp;
    }

    public static void Insert(int[] arr) {

        //遍历数字的次数
        for (int i = 1; i < arr.length; i++) {//默认第一个
            for (int j = i; j > 0; j--) {//从后往前比较
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }


    public static void InsertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {//默认第一个元素有序
            if (nums[i] < nums[i - 1]) {
                int j = i - 1;
                int x = nums[i];     //复制为哨兵，即存储待排序元素
                while (j >= 0 && x < nums[j]) { //后一个元素x如果更小就往前移动
                    nums[j + 1] = nums[j];//将前一个元素的值赋值到后一个元素上，因为前一个元素的值是比后一个大
                    j--;     //元素前移
                }
                nums[j + 1] = x;     //插入到正确位置
            }

        }

    }
}

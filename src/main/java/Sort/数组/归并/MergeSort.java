package Sort.数组.归并;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/1/9 上午11:39
 * 归并排序
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {13, 56, 2, 8, 90, 76, 32};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 1、先递归分段
     * 2、再合并
     */
    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;//只有一个元素

        //l<r：需要分解递归成只有一个元素
        int mid = l + (r - l) / 2;
        //完整数组arr 从上往下递归，先切一半
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        //合并
        merge(arr, l, mid, r);

    }

    //arr, l, mid, r确定位置                0               arr.length-1
    public static void merge(int[] arr, int l, int mid, int r) {
        //两个合并段起始下标: 1    3  ,   2   4
        //                 l   mid   mid+1 r
        int s1 = l;
        int s2 = mid + 1;
        int[] ret = new int[r - l + 1];//定义临时数组存放 拍好顺序的合并
        int i = 0;//表示ret临时数组的第一个下标

        while (s1 <= mid && s2 <= r) {//两个归并段都有数据
            if (arr[s1] <= arr[s2]) {
                ret[i++] = arr[s1++];
            } else {
                ret[i++] = arr[s2++];
            }
        }

        //2、退出一定是因为 两端 有一段全部放进临时数组 有一段还没有
        while (s1 <= mid) {
            ret[i++] = arr[s1++];
        }
        //判断s2是否还有数据 放入临时数组最后
        while (s2 <= r) {
            ret[i++] = arr[s2++];
        }


        //3、将临时数组拷贝到大数组
        for (int j = 0; j < ret.length; j++) {
            arr[j + l] = ret[j];

        }
    }
}

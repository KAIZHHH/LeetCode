import java.util.Arrays;

/**
 * @author kai
 * @date 2022/12/13 下午7:17
 */
public class T1 {
    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 2, 6, 7};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int l, int r) {
        if (l>=r) return;
        int i = l;
        int j = r;
        int tem = arr[l];
        while (i < j) {

            while (i < j && arr[j] >= tem) {
                j--;
            }
            while (i < j && arr[i] <= tem) {
                i++;
            }
            swap(arr, i, j);
        }
        arr[l] = arr[i];
        arr[i] = tem;

        quickSort(arr, l, i - 1);
        quickSort(arr, i + 1, r);
    }

    private static void swap(int[] arr, int i, int j) {
        int cur = arr[i];
        arr[i] = arr[j];
        arr[j] = cur;
    }
}

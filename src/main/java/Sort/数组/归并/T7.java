package Sort.数组.归并;

/**
 * @author kai
 * @date 2022/9/6 下午2:00
 */
public class T7 {
    public static void main(String[] args) {

    }

    public static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int s1 = l;
        int s2 = mid + 1;
        int[] ret = new int[r - l + 1];
        int i = 0;
        while (s1 <= mid && s2 <= r) {
            if (arr[s1] <= arr[s2]) {
                ret[i++] = arr[s1++];
            } else {
                ret[i++] = arr[s2++];
            }
        }
        while (s1 <= mid) {
            ret[i++] = arr[s1++];
        }
        while (s2 <= mid) {
            ret[i++] = arr[s2++];
        }
        for (int j = 0; j < ret.length; j++) {
            arr[j + l] = ret[j];
        }
    }
}

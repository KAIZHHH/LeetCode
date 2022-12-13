/**
 * @author kai
 * @date 2022/12/5 下午5:16
 */
public class Test {
    public static void main(String[] args) {

    }

    public static void test(int[] arr, int target) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            if (arr[l] + arr[r] < target) {
                l++;
            } else if (arr[l] + arr[r] > target) {
                r--;
            } else {
                System.out.println(arr[l]);
                System.out.println(arr[r]);
                l++;
                r--;
            }
        }
    }
}

package Sort.数组.希尔;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/2/26 上午10:33
 */
public class T3 {
    public static void main(String[] args) {
        int[] arr = new int[]{26, 53, 67, 48, 57, 13, 48, 32, 60, 50};
        System.out.println(Arrays.toString(arr));

        test2(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void test(int[] data) {
        //第一个for循环：用来定义分组次数：第一次一半为一组，第二次一半的一半为一组
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            //第二个for循环：遍历每一组的比较过程：第一次0，4，8比较 第二次1，5比较
            for (int i = increment; i < data.length; i++) {
                int temp = data[i];//记录比较元素
                int j = 0;
                //第三次for循环：第一次 4和0比较 第二次 8和4和0比较
                for (j = i - increment; j >= 0; j -= increment) {//
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }
                }
                data[j + increment] = temp;
            }
        }
    }

    public static void test2(int[] data) {
        for (int increment = data.length / 2; increment > 0; increment /= 2) {
            for (int i = increment; i < data.length; i++) {
                int temp = data[i];
                int j = 0;
                for (j = i - increment; j >= 0; j -= increment) {
                    if (temp < data[j]) {
                        data[j + increment] = data[j];
                    } else {
                        break;
                    }

                }
                data[j + increment] = temp;


            }

        }
    }
}

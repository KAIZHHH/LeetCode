package Greedy;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/2/17 下午3:29
 */
public class TestComparator {

    public static void main(String[] args) {
        //                 A  B
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Arrays.sort(people, (a, b) -> a[0] - b[0]);//排A升序
        Arrays.sort(people, (a, b) -> b[0] - a[0]);//排A降序
        Arrays.sort(people, (a, b) -> a[1] - b[1]);//排B升序
        Arrays.sort(people, (a, b) -> b[1] - a[1]);//排B降序

        System.out.println(Arrays.deepToString(people));//二维数组转字符串输出

        //更严谨
        Arrays.sort(people, (a, b) -> Integer.compare(a[0], b[0]));//排A升序
        Arrays.sort(people, (a, b) -> Integer.compare(b[0], a[0]));//排A降序
        Arrays.sort(people, (a, b) -> Integer.compare(a[1], b[1]));//排B升序
        Arrays.sort(people, (a, b) -> Integer.compare(b[1], a[1]));//排B降序

        System.out.println(Arrays.deepToString(people));//二维数组转字符串输出

//        Arrays.sort(people, (a, b) -> {
//            //A相同 排B
//            if (a[0] == b[0]) {
//                //B按照升序
//                return a[1] - b[1];
//            }
//            //A不同 排A 按照降序
//            return b[0] - a[0];
//        });
    }
}

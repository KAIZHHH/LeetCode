package 笔试.达达;

import java.util.ArrayList;
import java.util.List;

/**
 * @author kai
 * @date 2022/9/3 下午5:01
 */
public class Main3 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String[] split = sc.nextLine().split(",");
//        int start = Integer.parseInt(split[0]);
//        int end = Integer.parseInt(split[1]);
//        List<Integer> test = test(start, end);
//        for (int i = 0; i < test.size(); i++) {
//            if (i == test.size() - 1) {
//                System.out.print(test.get(i));
//            } else {
//                System.out.print(test.get(i) + ",");
//            }
//        }
        System.out.println(-5 & 6);
    }

    private static List<Integer> test(int start, int end) {
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (isValid(i)) list.add(i);
        }
        return list;
    }

    private static boolean isValid(int i) {
        String s = i + "";
        int l = 0;
        int r = s.length() - 1;
        if (l == r) return false;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

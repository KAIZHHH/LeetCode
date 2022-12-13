package 笔试.去哪儿;

import java.util.Arrays;

/**
 * @author kai
 * @date 2022/9/7 下午7:07
 */
public class Main2 {
    public static void main(String[] args) {
        String inHand = "SA SJ SQ SK S10 A10 C9";
        String s = showDown(inHand);
        System.out.println(s);
    }

    public static String showDown(String inHand) {
        String[] s = inHand.split(" ");
        int n = s.length;
        char[] kind = new char[n];
        int[] content = new int[n];
        for (int i = 0; i < n; i++) {
            kind[i] = s[i].charAt(0);
            if (s[i].length() == 2) {
                if (s[i].charAt(1) == 'A') {
                    content[i] = 14;
                } else if (s[i].charAt(1) == 'J') {
                    content[i] = 11;
                } else if (s[i].charAt(1) == 'Q') {
                    content[i] = 12;
                } else if (s[i].charAt(1) == 'K') {
                    content[i] = 13;
                } else {

                    int i1 = s[i].charAt(1) - '0';
                    content[i] = i1;
                }
            } else {
                String substring = s[i].substring(1);
                int i1 = Integer.parseInt(substring);
                content[i] = i1;
            }
        }
        Arrays.sort(content);
        Arrays.sort(kind);
        //判断四条
        for (int i = 0; i <= n - 4; i++) {
            if (content[i] == content[i + 1] && content[i] == content[i + 2] && content[i] == content[i + 3]) {
                return "SiTiao";
            }
        }
        for (int i = 0; i <= n - 5; i++) {
            if (content[i] == content[i + 1] && content[i] == content[i + 2] && content[i + 3] == content[i + 4]) {
                return "HuLu";
            }
        }
        for (int i = n - 1; i >= 5; i--) {
            if (content[i] == 14 && content[i - 1] == 13 && content[i - 2] == 12 && content[i - 3] == 11 && content[i - 4] == 10) {
                return "HuangJiaTongHuaShun";
            }
        }
        for (int i = 0; i <= n - 5; i++) {
            if (content[i] == content[i + 1] && content[i] == content[i + 2] && content[i] != content[i + 3] && content[i] != content[i + 4]
                    && content[i + 3] != content[i + 4]) {
                return "SanTiao";

            }
        }
        for (int i = 0; i <= n - 4; i++) {
            if (content[i] == content[i + 1] && content[i + 2] == content[i + 3]) {
                return "LiangDui";

            }
        }
        for (int i = 0; i <= n - 5; i++) {
            if (content[i] == content[i + 1] && content[i] != content[i + 2] && content[i] != content[i + 3] && content[i] != content[i + 4] && content[i + 2] != content[i + 3] && content[i + 3] != content[i + 4]) {
                return "YiDui";

            }
        }
//        for (int i = 0; i <= n - 5; i++) {
//            if (content[i] + 1 == content[i + 1] && content[i + 1] + 1 == content[i + 2] && content[i + 2] + 1 == content[i + 3] && content[i + 3] + 1 == content[i + 4]) {
//                return "ShunZi";
//
//            }
//        }
        for (int i = 0; i <= n - 5; i++) {
            if (kind[i] == kind[i + 1] && kind[i] == kind[i + 2] && kind[i] == kind[i + 3] && kind[i] == kind[i + 4]) {
                return "TongHua";
            }

        }
        return "ShunZi";
    }
}

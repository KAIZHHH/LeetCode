package 笔试.正浩;

import java.util.Scanner;

class 重排字符串 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String s = sc.nextLine();
        int n = Integer.valueOf(s);
        String s1 = sc.nextLine();
        String string = reorganizeString(s1);
        if (string.equals("")) {
            System.out.println("no");
        }else{
            System.out.println("yes");
            System.out.println(string);

        }
    }
    public static String reorganizeString(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;

        int[] count = new int[26];
        for (char c : arr) {
            count[c - 'a']++;
        }

        int maxIndex = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > count[maxIndex]) {
                maxIndex = i;
            }
        }

        if (count[maxIndex] > (n + 1) / 2) return "";

        // 先把出现次数最多的字符放在偶数位置上
        char[] res = new char[n];
        int i = 0;
        while (count[maxIndex]-- > 0) {
            res[i] = (char) ('a' + maxIndex);
            i += 2;
        }

        // 考虑其他的字符
        for (int j = 0; j < count.length; j++) {
            while (count[j]-- > 0) {
                if (i >= n) i = 1; // 偶数位置用完了，放到奇数位置
                res[i] = (char) ('a' + j);
                i += 2;
            }
        }

        return String.valueOf(res);
    }
}

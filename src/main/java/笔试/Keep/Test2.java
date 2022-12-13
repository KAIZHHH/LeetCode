package 笔试.Keep;

public class Test2 {
    public static void main(String[] args) {
        int num = 5124;
        int i = maximumSwap(num);
        System.out.println(i);
    }

    public static int maximumSwap(int num) {
        String str = num + "";
        char[] ch = str.toCharArray();
        int n = ch.length;
        int max = 0;
        int change = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ch[i] < ch[j]) {
                    if (ch[j] > max) {
                        max = ch[j];
                        change = j;
                    }
                }
            }
            if (max != 0) {
                swap(ch, i, change);
                String s = String.valueOf(ch);
                int res = Integer.parseInt(s);
                return res;
            }
        }
        return num;
    }

    public static void swap(char[] ch, int i, int j) {
        int temp = ch[i];
        ch[i] = ch[j];
        ch[j] = (char) temp;
    }
}

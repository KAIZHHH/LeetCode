package 笔试.Test;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.next();
        String res = test(str);
        System.out.println(res);
    }

    public static String test(String str) {
        Set<Character> set = new HashSet();
        int l = 0;
        int r = 0;
        int n = str.length();
        int max = 0;
        int start = 0;
        int end = 0;
        while (r < n) {
            if (!set.contains(str.charAt(r))) {
                //不存在
                if (set.size() < 3) {
                    set.add(str.charAt(r));

                    if (r - l + 1 > max) {
                        max = r - l + 1;
                        start = l;
                        end = r;
                    }
                    r++;

                } else {
                    char c = str.charAt(l);
                    set.remove(c);
                    while (str.charAt(l) == c) {
                        l++;
                    }
                    //=3了 又要加元素

                    if (r - l + 1 > max) {
                        max = r - l + 1;
                        start = l;
                        end = r;
                    }
                }
            } else {
                set.add(str.charAt(r));

                if (r - l + 1 > max) {
                    max = r - l + 1;
                    start = l;
                    end = r;
                }
                r++;
            }

        }
        return str.substring(start, end+1);
    }
}

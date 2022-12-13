package 笔试.深信服;

import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param histogram int整型一维数组
     * @return int整型
     */
    public int histogram_max_area (int[] histogram) {
         int res = 0;
        for (int i = 0; i < histogram.length; i++) {
            int iw = 1;
            for (int back = i - 1; back >= 0; back--) {
                if (histogram[i] > histogram[back]) {
                    break;
                } else {
                    iw++;
                }
            }
            for (int front = i + 1; front < histogram.length; front++) {
                if (histogram[i] > histogram[front]) {
                    break;
                } else {
                    iw++;
                }
            }
            res = Math.max(histogram[i] + iw, res);
        }
        return res;
    }
}

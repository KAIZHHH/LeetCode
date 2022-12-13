package 笔试.五八同城;

import org.junit.Test;

/**
 * @author kai
 * @date 2022/11/5 下午7:17
 */
public class Main {
    @Test
    public void test() {
        int a = 1;
        Integer b = 1;
        Integer c = 1000;

        fun(a, b, c);
        System.out.println(a + " "+b + " " + c);
    }


    private void fun(int a, Integer b, Integer c) {
        a++;
        b++;
        c++;

    }
}


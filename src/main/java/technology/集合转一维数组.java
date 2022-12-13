package technology;

import org.junit.Test;

import java.util.*;

/**
 * @author kai
 * @date 2022/8/3 下午11:57
 */
public class 集合转一维数组 {
    @Test
    public void test1() {
        List<String> arr = new ArrayList<String>();
        arr.add("a");
        arr.add("b");
        arr.add("b");//可以添加重复的对象
        System.out.println(arr);

        Object[] o = arr.toArray();
        for (int i = 0; i < o.length; i++) {
            String e = (String) o[i];
            System.out.println(e);
        }

    }

    @Test
    public void test2() {
        Set<Integer> set = new HashSet();
        set.add(1);
        set.add(1);
        set.add(3);//可以添加重复的对象

        Integer[] res = set.toArray(new Integer[set.size()]);
        System.out.println(Arrays.toString(res));
    }
}

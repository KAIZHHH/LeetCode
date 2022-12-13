package technology;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author kai
 * @date 2022/8/23 上午12:54
 */
public class 排序set {
    @Test
    public void test1() {
        //1.创建一个无序的Set集合,并添加元素;
        Set<Character> set = new HashSet();
        set.add('n');
        set.add('b');
        set.add('c');
        set.add('a');
        set.add('d');
        //创建TreeSet排序的lambda表达式; 相比于传统方式,代码量上有了很大的减少;
        TreeSet<Character> zset = new TreeSet<>(((o1, o2) -> o1.compareTo(o2)));
        zset.addAll(set);
        System.out.println(zset);
    }

    @Test
    public void test2() {
        //1.创建一个无序的Set集合,并添加元素;
        Set<Integer> set = new HashSet();
        set.add(100);
        set.add(20);
        set.add(30);
        //创建TreeSet排序的lambda表达式; 相比于传统方式,代码量上有了很大的减少;
        TreeSet<Integer> zset = new TreeSet<>(((o1, o2) -> o2.compareTo(o1)));
        zset.addAll(set);
        System.out.println(zset);
    }
}

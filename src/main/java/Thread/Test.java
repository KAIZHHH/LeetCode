package Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @Description
 * @Author huangkai.zhong
 * @Data 2022/11/8 6:20 PM
 */
public class Test {
    public static void main(String[] args) {
        //    Function<T, R> -> R apply(T t);
        Function<String, Integer> function = (t) -> 1;
        //   Supplier<T> -> T get();
        Supplier<String> supplier = () -> "hello";
        //      void run();
        Runnable runnable = () -> System.out.println("run");
        //   Consumer<T> -> void accept(T t);
        Consumer<String> consumer = (t) -> System.out.println("1" + t);
        //  Callable<V> ->  V call()
        Callable<String> callable = () -> "hello";


    }
}

package com.wmm.functionalinterface;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author wangmingming160328
 * @date @2020/7/24 15:21
 */
public class FunctionalInterfaceDemo {
    public static void main(String[] args) {
        FunctionalInterfaceDemo functionalInterfaceDemo = new FunctionalInterfaceDemo();

        System.out.println(functionalInterfaceDemo.getValue(() -> "hello"));
        functionalInterfaceDemo.accept("wmm", System.out::println);
        functionalInterfaceDemo.test(4, value -> value > 0);
        List<Integer> list = functionalInterfaceDemo.apply(5, value -> {
            if (value > 1) {
                return Collections.singletonList(value);
            }
            return null;
        });
    }

    /**
     * {@link Supplier}无参有返回值
     * @param supplier Supplier接口
     * @return String
     */
    public String getValue(Supplier<String> supplier) {
        return supplier.get();
    }

    /**
     * {@link Consumer}有参无返回值
     * @param str 参数
     * @param consumer Consumer接口
     * @return
     */
    public void accept(String str, Consumer<String> consumer) {
        consumer.accept(str);
    }

    public boolean test(Integer integer, Predicate<Integer> predicate) {
        return predicate.test(integer);
    }

    public List<Integer> apply(Integer integer, Function<Integer, List<Integer>> function) {
        return function.apply(integer);
    }
}

package com.wmm.functionalinterface;

import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 当一个接口中存在多个抽象方法时，如果使用lambda表达式，并不能智能匹配对应的抽象方法，因此引入了函数式接口的概念
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
     *
     * @param supplier Supplier接口
     * @return String
     */
    public String getValue(Supplier<String> supplier) {
        return supplier.get();
    }

    /**
     * {@link Consumer}有参无返回值
     *
     * @param str      参数
     * @param consumer Consumer接口
     * @return
     */
    public void accept(String str, Consumer<String> consumer) {
        consumer.accept(str);
    }

    /**
     * {@link Predicate}有参有返回值，返回值类型为boolean
     *
     * @param integer   参数
     * @param predicate 接口
     * @return
     */
    public boolean test(Integer integer, Predicate<Integer> predicate) {
        return predicate.test(integer);
    }

    /**
     * {@link Function}有参有返回值
     *
     * @param integer
     * @param function
     * @return
     */
    public List<Integer> apply(Integer integer, Function<Integer, List<Integer>> function) {
        return function.apply(integer);
    }
}

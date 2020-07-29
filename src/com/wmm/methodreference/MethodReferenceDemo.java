package com.wmm.methodreference;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;

/**
 * 方法引用：若lambda体内的方法是已有方法，则可以用方法调用。他是lambda的另一种写法，比lambda更简洁。
 * 三种表现形式：
 * 1. 对象::实例方法名
 * 2. 类::静态方法名
 * 3. 类::实例方法名 （lambda参数列表中第一个参数是实例方法的调用者，第二个参数是实例方法的参数时可用）
 * @author wangmingming160328
 * @date @2020/7/29 15:29
 */
public class MethodReferenceDemo {
    public static void main(String[] args) {
        int[] gradeArray = {7, 1, 3, 5, 4, 8, 6, 2, 9};
        //对象::实例方法名
        Arrays.stream(gradeArray).forEach(value -> System.out.println(value));
        Arrays.stream(gradeArray).forEach(System.out::println);
        //类::静态方法名
        BiFunction<Integer, Integer, Integer> biFunction = (integer, integer2) ->  Integer.compare(integer, integer2);
        BiFunction<Integer, Integer, Integer> biFunction1 = Integer::compare;
        System.out.println(biFunction.apply(5,10));
        System.out.println(biFunction1.apply(5,10));
        //类::实例方法名
        BiPredicate<String, String> biPredicate = (s, s2) -> s.equals(s2);
        BiPredicate<String, String> biPredicate1 = String::equals;
        System.out.println(biPredicate.test("5","5"));
        System.out.println(biPredicate.test("5","5"));

        //构造器引用
        DeviceWithNoIdFactory deviceWithNoIdFactory = Device::new;
        Device device = deviceWithNoIdFactory.create();
        System.out.println(device);
        DeviceWithIdAndNameFactory deviceWithIdAndNameFactory = Device::new;
        Device device1 = deviceWithIdAndNameFactory.create("1", "tom's pc");
        System.out.println(device1);

        //数组引用
        Function<Integer, String[]> function = integer -> new String[integer];
        Function<Integer, String[]> function1 = String[]::new;
        Arrays.stream(function1.apply(5)).forEach(System.out::println);
    }
}

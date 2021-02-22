package com.wmm.stream;

import com.wmm.methodreference.Device;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 流式编程
 * 能应用在一组元素上一次执行的操作序列。Stream 操作分为中间操作或者最终操作两种，最终操作返回一特定类型的计算结果，而中间操作返回Stream本身
 * 流程：获取一个数据源（source）→ 数据转换（由中间操作完成）→执行操作获取想要的结果（由最终操作完成）
 * 可应用的数据类型：Collection的子类，数组
 *
 * @author wangmingming160328
 * @date @2020/7/29 17:35
 */
public class StreamDemo {
    public static void main(String[] args) {
        init();
        intermediate();
        terminal();
    }

    /**
     * 初始化
     */
    private static void init() {
        List<String> list = new ArrayList<>();
        Stream<String> stream = list.stream();

        String[] strArray = new String[20];
        Stream<String> stream1 = Arrays.stream(strArray);

        Stream<Device> deviceStream = Stream.of(new Device(), new Device("1", "1"));
        deviceStream.forEach(System.out::println);
        //恒定流
        Stream<Device> deviceStream1 = Stream.generate(() -> new Device());
        deviceStream1.limit(20).forEach(System.out::println);

        //无限迭代流
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(20).forEach(System.out::println);


    }

    /**
     * 中间操作
     */
    private static void intermediate() {
        //flatMap将流中每个元素执行自定义函数转换为流合并为一个新流后返回
        Stream<List<Integer>> inputStream = Stream.of(Collections.singletonList(1), Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3, 4));
        inputStream.flatMap(Collection::stream).forEach(System.out::print);
        System.out.println();
        inputStream = Stream.of(Collections.singletonList(1), Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3, 4));
        inputStream.forEach(System.out::print);
        System.out.println();
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        Stream<Integer> integerStream = stream4.limit(20)
                //丢弃流中的n个元素，从第一个元素开始
                .skip(2)
                //对流不做修改，但是流中每个元素都会被指定函数消费
                .peek(e -> System.out.println("value: " + e))
                //倒序
                .sorted((o1, o2) -> {
                    if (o1 > o2) {
                        return -1;
                    } else {
                        return 1;
                    }
                })
                //返回一个由 流中每个元素执行自定义函数后的结果 组成的流
                .map(element -> element - 1)
                //去重
                .distinct();
    }

    /**
     * 终止操作
     */
    private static void terminal() {
        //返回用Option对象包装起来的第一个元素
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);
        Optional<Integer> integer = integerStream.findFirst();
        System.out.println(integer.map(value -> value++).orElse(-1));

        //map reduce
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer count2 = list.stream().reduce(100, Integer::sum);
        System.out.println(count2);

        //将流转换为其他形式
        List<Integer> array = new ArrayList<>(list);

        //检查是否所有元素都匹配所提供的的断言性函数
        System.out.println(list.stream().allMatch(element -> element > 1));
        //检查是否至少存在一个元素匹配所提供的的断言性函数
        System.out.println(list.stream().anyMatch(element -> element > 1));
        //检查是否没有元素匹配所提供的的断言性函数
        System.out.println(list.stream().noneMatch(element -> element < 0));
    }
}

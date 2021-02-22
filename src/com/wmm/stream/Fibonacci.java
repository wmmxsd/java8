package com.wmm.stream;

import java.util.stream.Stream;

/**
 * @author wangmingming160328
 * @date @2021/1/19 10:33
 */
public class Fibonacci {
    int x = 1;

    Stream<Integer> numbers() {
        //iterator():seed是第一个元素,然后其他顺序的元素才是result的值
        return Stream.iterate(1, i -> {
            int result = x + i;
            x = i;
            return result;
        });
    }

    public static void main(String[] args) {
        new Fibonacci().numbers()
                .limit(10) // 然后取 10 个
                .forEach(System.out::println);
    }
}

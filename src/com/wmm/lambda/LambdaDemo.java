package com.wmm.lambda;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author wangmingming160328
 * @date @2020/7/24 9:37
 */
public class LambdaDemo {
    public static void main(String[] args) {

    }

    private static void nonLambdaDemo() {
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };

        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }

    private static void lambdaDemo() {
        Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1,o2);
        TreeSet<Integer> treeSet = new TreeSet<>(comparator);
    }
}

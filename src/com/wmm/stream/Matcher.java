package com.wmm.stream;

import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author wangmingming160328
 * @date @2021/1/20 14:35
 */
interface Matcher extends BiPredicate<Stream<Integer>, Predicate<Integer>> {}

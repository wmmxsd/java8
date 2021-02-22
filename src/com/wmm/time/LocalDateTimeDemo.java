package com.wmm.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAmount;

/**
 * 日期和时间类LocalDateTime、日期类LocalDate、时间类LocalTime
 * LocalDateTime对象可以被拆分为LocalDate、LocalTime，同时LocalDate、LocalTime可以组成一个LocalDateTime
 * @author wangmingming160328
 * @date @2020/7/22 11:40
 */
public class LocalDateTimeDemo {
    public static void main(String[] args) {
        //初始化
        System.out.println("**********初始化**********");
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.now(Clock.systemDefaultZone());
        LocalDateTime localDateTime2 = LocalDateTime.now(ZoneId.systemDefault());
        LocalDateTime localDateTime3 = LocalDateTime.of(2020, 2, 2, 2, 2);
        LocalDateTime localDateTime4 = LocalDateTime.of(2020, 2, 2, 2, 2, 2);
        LocalDateTime localDateTime5 = LocalDateTime.of(2020, 2, 2, 2, 2, 2, 2);

        System.out.println(localDateTime.toString());
        System.out.println(localDateTime1.toString());
        System.out.println(localDateTime2.toString());
        System.out.println(localDateTime3.toString());
        System.out.println(localDateTime4.toString());
        System.out.println(localDateTime5.toString());

        //互相转换
        System.out.println("**********LocalDateTime、LocalDateLocalTime互相转换**********");
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime6 = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime6.toString());
        System.out.println(localDateTime6.toLocalDate());
        System.out.println(localDateTime6.toLocalTime());

        //常用get方法
        System.out.println("**********常用get方法**********");
        LocalDateTime now = LocalDateTime.now();
        System.out.println("now.getYear(): "  + now.getYear());
        System.out.println("now.getMonth(): "  + now.getMonth());
        System.out.println("now.getMonthValue(): "  + now.getMonthValue());
        System.out.println("now.getDayOfMonth(): "  + now.getDayOfMonth());
        System.out.println("now.getHour(): "  + now.getHour());
        System.out.println("now.getMinute(): "  + now.getMinute());
        System.out.println("now.getSecond(): "  + now.getSecond());
        System.out.println("now.getDayOfYear(): "  + now.getDayOfYear());
        System.out.println("now.getDayOfWeek(): "  + now.getDayOfWeek());
        System.out.println("now.getNano(): "  + now.getNano());

        //日期时间的加减
        System.out.println("**********日期时间的加减**********");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss.SSS");
        DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println("当前时间：" + now.format(dateTimeFormatter));
        System.out.println("当前时间：" + now.format(dateTimeFormatter1));

        LocalDateTime plusTime = now.plusYears(1).plusMonths(1).plusDays(1).plusHours(1).plusMinutes(1).plusSeconds(1).plusNanos(1000000);
        System.out.println("加后的时间:" + plusTime.format(dateTimeFormatter));
        LocalDateTime minusTime = now.minusYears(1).minusMonths(1).minusDays(1).minusHours(1).minusMinutes(1).minusSeconds(1).minusNanos(1000000);
        System.out.println("减后的时间:" + minusTime.format(dateTimeFormatter));
        System.out.println("now.plus(Duration.ofHours(1))" + now.plus(Duration.ofHours(1)));
        System.out.println("now.plus(Period.ofYears(1))" + now.plus(Period.ofYears(1)));
        System.out.println("now.minus(TemporalAmount amountToSubtract):" + now.minus(Duration.ofDays(1)));
        System.out.println("now.plus(2, ChronoUnit.MONTHS): " + now.plus(2, ChronoUnit.CENTURIES));

        //日期对比
        System.out.println("**********日期对比**********");
        LocalDateTime before = now.minusYears(2);
        LocalDateTime after = now.plus(Period.ofYears(20));
        System.out.println("before:" + before.format(dateTimeFormatter));
        System.out.println("now:" + now.format(dateTimeFormatter));
        System.out.println("after:" + after.format(dateTimeFormatter));
        System.out.println("after是在now之后:" + after.isAfter(now));
        System.out.println("before是在now之前:" + before.isBefore(now));
        System.out.println("after.isEqual(now.plus(Period.ofYears(20))):" + after.isEqual(now.plus(Period.ofYears(20))));
    }
}

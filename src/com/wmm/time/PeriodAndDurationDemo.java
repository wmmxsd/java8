package com.wmm.time;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

/**
 * @author wangmingming160328
 * @date @2020/7/22 16:05
 */
public class PeriodAndDurationDemo {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime before = now.minusYears(2);
        //Period
        System.out.println(now + "和" + before + "对比：" + Period.between(now.toLocalDate(), before.toLocalDate()).getYears() + "年");
        System.out.println(now + "和" + before + "对比：" + Period.between(now.toLocalDate(), before.toLocalDate()).getMonths() + "月");
        System.out.println(before + "和" + now + "对比：" + Period.between(before.toLocalDate(), now.toLocalDate()).getYears() + "年");
        System.out.println(before + "和" + now + "对比：" + Period.between(before.toLocalDate(), now.toLocalDate()).getMonths() + "月");
        System.out.println(before + "和" + now + "相隔：" + now.until(before, ChronoUnit.MONTHS) + "月");
        System.out.println(before + "和" + now + "相隔：" + before.until(now, ChronoUnit.MONTHS) + "月");

        //Duration
        System.out.println(Duration.between(now.minusMonths(1), now).toDays());
        Duration duration = Duration.ofSeconds(60 * 60L);
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toMillis());
        System.out.println(duration.toNanos());
    }
}

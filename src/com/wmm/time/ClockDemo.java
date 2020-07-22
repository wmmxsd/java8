package com.wmm.time;

import java.time.Clock;
import java.time.ZoneId;

/**
 * Clock用于查找当前时刻，可以用来获取某个时区下当前的日期和时间
 * @author wangmingming160328
 * @date @2020/7/22 15:54
 */
public class ClockDemo {
    public static void main(String[] args) {
        Clock clock = Clock.systemDefaultZone();
        System.out.println(clock.instant().toString());
        System.out.println(Clock.system(ZoneId.of("America/Sao_Paulo")).instant().atZone(ZoneId.of("America/Sao_Paulo")).toLocalDateTime().toString());
        //世界协调时UTC
        clock = Clock.systemUTC();
        //通过Clock获取当前时刻
        System.out.println("当前时刻为：" + clock.instant());
        //获取clock对应的毫秒数，与System.currentTimeMillis()输出相同
        System.out.println(clock.millis());
        System.out.println(System.currentTimeMillis());
    }
}

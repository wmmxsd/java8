package com.wmm.time;


import java.time.Instant;

/**
 * 是不带时区的即时时间点（有点像 java.util.Date）,精确到纳秒
 * 如果使用纳秒去表示一个时间则原来使用一位Long类型是不够的，
 * 需要占用更多一点的存储空间，实际上其内部是由两个Long字段组成，
 * 第一个部分保存的是自标准Java计算时代（就是1970年1月1日开始）到现在的秒数，
 * 第二部分保存的是纳秒数（永远不会超过999,999,999）。
 *
 *
 * 与LocalDateTime的区别：
 * Instant表示一个格林威治时间线上的一个时间点（偏移量）
 * 而LocalDateTime着重表示日期时间
 * 两个人都在2013年7月2日11点出生，第一个人是在英国出生，而第二个是在加尼福利亚，
 * 如果我们问他们是在什么时候出生的话，则他们看上去都是 在同样的时间出生（就是LocalDateTime所表达的），
 * 但如果我们根据时间线（如格林威治时间线）去仔细考察，则会发现在出生的人会比在英国出生的人稍微晚几个小时（这就是Instant所表达的概念，并且要将其转换为UTC格式的时间）
 * @author wangmingming160328
 * @date @2020/7/22 14:14
 */
public class InstantDemo {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.getNano());
        //1970-01-01T00:00:00Z + x毫秒
        Instant now = Instant.ofEpochMilli(instant.toEpochMilli());
        System.out.println(now);
        //1970-01-01T00:00:00Z + x秒
        System.out.println(Instant.ofEpochSecond(instant.getEpochSecond()));
        Instant instant3 = Instant.ofEpochSecond(instant.getEpochSecond(), instant.getNano());
        Instant instant4 = Instant.ofEpochSecond(instant.getEpochSecond() + 60, instant.getNano());
        System.out.println(instant3);
        System.out.println(instant4);
    }
}

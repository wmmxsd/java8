package com.wmm.optional;

import com.wmm.methodreference.Device;

import java.util.Optional;

/**
 * {@link java.util.Optional}是一个容器对象，可以快速定位NPE
 * 个人理解：Optional主要有两个用途。
 * 一是用于流式编程如：list.stream().findFirst().orElse(new User())
 * 二是用于返回类型，便于当值不存在时的逻辑处理
 *
 * @author wangmingming160328
 * @date @2020/7/30 10:51
 */
public class OptionalDemo {
    public static void main(String[] args) {
        before(null);
        after(null);
    }

    /**
     * jdk1.8以前的非空判断
     *
     * @param user
     */
    private static void before(User user) {
        if (user != null) {
            Device device = user.device;
            if (device != null) {
                System.out.println(device.getName());
            }
        }
    }

    /**
     * jdk1.8的非空判断
     *
     * @param user
     */
    private static void after(User user) {
        Device device = new Device("123", "王小二");
        User wang = new User("wang's pc", device);
        //允许空值存在使用ofNullable方法，对空值可做处理
        //orElse():当前值为空值时返回一个新值，不为空返回当前值
        User tempUser1 = Optional.ofNullable(user).orElse(new User("tom", new Device()));
        //orElseGet():当前值为空值时返回一个新值，不为空返回当前值，
        // 与orElse的区别是若是非空值，roElse仍会执行括号中的方法或初始化语句而orElseGet不会
        User tempUser2 = Optional.ofNullable(user).orElseGet(() -> new User("tom", new Device()));
        //orElseThrow():当前值为空值时抛出异常，不为空返回当前值
        User tempUser = Optional.ofNullable(wang).orElseThrow(NullPointerException::new);

        //不允许空值可使用of方法创建Optional对象
        Optional<User> optional = Optional.of(wang);

        Optional<Integer> opt = Optional.ofNullable(null);
        //NPE（get()方法中若optional存在空值则报错）
        //System.out.println(optional.get());

        String name = Optional.of(wang).map(element -> element.name).orElseThrow(NullPointerException::new);
        System.out.println(name);

        name = Optional.of(wang).flatMap(element -> Optional.ofNullable(element.name)).orElseThrow(NullPointerException::new);
        System.out.println(name);
    }

    private static class User {
        String name;
        Device device;

        public User(String name, Device device) {
            this.name = name;
            this.device = device;
        }
    }
}

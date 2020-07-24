package com.wmm.lambda.optimization;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangmingming160328
 * @date @2020/7/24 14:51
 */
public class FourOptimization {
    public static void main(String[] args) {
        List<User> userList = new ArrayList<>();
        User user0 = new User("王1", 50, 1);
        User user1 = new User("王2", 40, 1);
        User user2 = new User("王3", 60, 2);
        User user3 = new User("王4", 80, 1);
        User user4 = new User("王5", 30, 1);
        User user5 = new User("王6", 10, 1);
        userList.add(user0);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.stream().filter(user -> user.getAge() > 20).forEach(user -> System.out.println(user));
        userList.stream().filter(user -> user.getAge() > 20).forEach(System.out::println);
        System.out.println("********************************");
        userList.stream().filter(user -> user.getSex() == 1).forEach(System.out::println);
    }
}

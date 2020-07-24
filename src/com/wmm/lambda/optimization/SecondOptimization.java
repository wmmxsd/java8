package com.wmm.lambda.optimization;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangmingming160328
 * @date @2020/7/24 14:32
 */
public class SecondOptimization {
    public List<User> filter(List<User> users, FirstOptimization.Filter<User> filter) {
        List<User> userList = new ArrayList<>();
        for (User user : users) {
            if (filter.filter(user)) {
                userList.add(user);
            }
        }
        return userList;
    }

    public static void main(String[] args) {
        SecondOptimization secondOptimization = new SecondOptimization();
        List<User> userList = secondOptimization.filter(new ArrayList<>(), new FirstOptimization.Filter<User>() {
            @Override
            public boolean filter(User user) {
                return user.getAge() > 20;
            }
        });
        userList = secondOptimization.filter(userList, new FirstOptimization.Filter<User>() {
            @Override
            public boolean filter(User user) {
                return 1 == user.getSex();
            }
        });
    }

    interface Filter<T> {
        boolean filter(T t);
    }
}

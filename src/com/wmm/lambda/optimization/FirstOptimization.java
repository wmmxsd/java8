package com.wmm.lambda.optimization;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangmingming160328
 * @date @2020/7/24 14:22
 */
public class FirstOptimization {
    public List<User> filter(List<User> users, Filter<User> filter) {
        List<User> userList = new ArrayList<>();
        for (User user : users) {
            if (filter.filter(user)) {
                userList.add(user);
            }
        }
        return userList;
    }

    public static void main(String[] args) {
        FirstOptimization firstOptimization = new FirstOptimization();
        AgeFilter ageFilter = firstOptimization.new AgeFilter();
        List<User> userList = firstOptimization.filter(new ArrayList<>(), ageFilter);
        userList = firstOptimization.filter(userList, firstOptimization.new SexFilter());
    }

    interface Filter<T> {
        boolean filter(T t);
    }

    public class AgeFilter implements Filter<User> {
        @Override
        public boolean filter(User user) {
            return user.getAge() > 20;
        }
    }

    public class SexFilter implements Filter<User> {
        @Override
        public boolean filter(User user) {
            return 1 == user.getSex();
        }
    }
}

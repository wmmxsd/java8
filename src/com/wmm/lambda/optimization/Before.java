package com.wmm.lambda.optimization;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangmingming160328
 * @date @2020/7/24 14:13
 */
public class Before {
    public List<User> filterByAge(List<User> users) {
        List<User> userList = new ArrayList<>();
        for (User user : users) {
            if (20 < user.getAge()) {
                userList.add(user);
            }
        }
        return userList;
    }

    public List<User> filterBySex(List<User> users) {
        List<User> userList = new ArrayList<>();
        for (User user : users) {
            if (1 == user.getSex()) {
                userList.add(user);
            }
        }
        return userList;
    }

    public static void main(String[] args) {
        Before before = new Before();
        List<User> userList = before.filterByAge(new ArrayList<>());
        userList = before.filterBySex(userList);
    }
}

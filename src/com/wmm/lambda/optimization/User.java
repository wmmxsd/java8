package com.wmm.lambda.optimization;

/**
 * @author wangmingming160328
 * @date @2020/7/24 14:11
 */
public class User {
    private String name;
    private Integer age;
    private Integer sex;

    public User(String name, Integer age, Integer sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + ", sex=" + sex + '}';
    }
}

package com.wmm.constructorreference;

/**
 * @author wangmingming160328
 * @date @2021/1/15 15:18
 */
public class DogApp {
    public static void main(String[] args) {
        DogFactoryA dogFactoryA = Dog::new;
        DogFactoryB dogFactoryB = Dog::new;
        DogFactoryC dogFactoryC = Dog::new;
        System.out.println(dogFactoryA.build());
        System.out.println(dogFactoryB.build("招财"));
        System.out.println(dogFactoryC.build("招财", 2));
    }
}

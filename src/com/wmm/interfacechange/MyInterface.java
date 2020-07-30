package com.wmm.interfacechange;

/**
 * <p>jdk1.8以前，接口中只能有全局静态常量，抽象方法，方法声明。</p>
 * <p>jdk1.8新增默认方法（如果接口实现类同时继承了一个包含和接口中的方法同名的方法，则jvm会调用父类的方法），静态方法。</p>
 * <p>接口特点回顾：</p>
 * <p>方法和属性默认都是public修饰，也可以使用protected，但不能用private</p>
 * <p>所有的属性都是静态的常量，默认省略了public static final修饰符，属性的值必须初始化</p>
 * <p>所有的方法默认省略了public abstract修饰符</p>
 * @author wangmingming160328
 * @date @2020/7/30 10:07
 */
public interface MyInterface {
    String NAME = "Tom";

    abstract void say();

    /**
     * jdk8新增的默认方法，必须有具体的实现。
     */
    default void eat(){
        System.out.println("eat");
    }

    /**
     * jdk8新增的静态方法
     */
    static void sit() {
        System.out.println("sit");
    }
}

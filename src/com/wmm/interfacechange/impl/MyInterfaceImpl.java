package com.wmm.interfacechange.impl;

import com.wmm.interfacechange.MyInterface;

/**
 * @author wangmingming160328
 * @date @2020/7/30 10:10
 */
public class MyInterfaceImpl implements MyInterface {
    @Override
    public void say() {
        System.out.println(NAME);
    }

    public static void main(String[] args) {
        MyInterface myInterface = new MyInterfaceImpl();
        myInterface.eat();
        MyInterface.sit();
        myInterface.say();
    }
}

package com.wmm.methodreference;

/**
 * @author wangmingming160328
 * @date @2020/7/29 15:57
 */
public class Device {
    private String id;
    private String name;

    public Device() {
    }

    public Device(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Device{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
    }
}

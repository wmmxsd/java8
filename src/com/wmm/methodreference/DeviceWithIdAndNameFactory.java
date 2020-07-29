package com.wmm.methodreference;

/**
 * @author wangmingming160328
 * @date @2020/7/29 16:30
 */
@FunctionalInterface
public interface DeviceWithIdAndNameFactory {
    Device create(String id, String name);
}

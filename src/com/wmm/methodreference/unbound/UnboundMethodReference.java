package com.wmm.methodreference.unbound;

/**
 * @author wangmingming160328
 * @date @2021/1/7 16:44
 */
public class UnboundMethodReference {
    public static void main(String[] args) {
         //MakeString ms = X::f; // [1]
        TransformX sp = X::f;
        X x = new X();
        System.out.println(sp.transform(x)); // [2]
        System.out.println(x.f()); // 同等效果
    }
}

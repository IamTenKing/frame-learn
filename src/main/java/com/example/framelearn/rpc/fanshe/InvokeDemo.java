package com.example.framelearn.rpc.fanshe;

import java.lang.reflect.Method;

/**
 * @author jt
 * @date 2020-6-4
 */
public class InvokeDemo {
    public static void main(String[] args) throws Exception {

        Class<?> aClass = Class.forName("com.example.framelearn.rpc.serialize.Student");
        //aClass.getDeclaredMethod才可以获取到私有方法，
        Method print = aClass.getDeclaredMethod("print");
        //获取不到私有方法
//        Method print1 = aClass.getMethod("print");
        Object o = aClass.newInstance();
        //暴力反射
        print.setAccessible(true);
        print.invoke(o);


    }
}

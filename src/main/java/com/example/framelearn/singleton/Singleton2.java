package com.example.framelearn.singleton;

import sun.security.jca.GetInstance;

/**
 *
 * 静态内部类实现1
 * @author jt
 * @date 2020-8-8
 */
public class Singleton2 {

    private String name;


    private Singleton2(){

    }

    //从过静态内部类去new
    //当 Singleton 类被加载时，静态内部类 SingletonHolder 没有被加载进内存。只有当调用 getUniqueInstance() 方法从而触发 SingletonHolder.INSTANCE 时 SingletonHolder 才会被加载，此时初始化 INSTANCE 实例，并且 JVM 能确保 INSTANCE 只被实例化一次。
    //
    //这种方式不仅具有延迟初始化的好处，而且由 JVM 提供了对线程安全的支持。
    private static class SingletonHolder{
        private static Singleton2 singleton2 = new Singleton2();
    }

    //提供一个获取实例方法
    public static Singleton2 getInstance(){
        return SingletonHolder.singleton2;
    }


}

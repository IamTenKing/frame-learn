package com.example.framelearn.classloader;

/**
 * @author jt
 * @date 2020-7-22
 */
public class Pojo {

    private static String age="111";
    private String name="test";

    static {
        System.out.println("hello....");
        System.out.println("age:"+age);
    }

    public Pojo() {
        System.out.println("执行构造方法。。。。。。。。。。。。。");
    }

}

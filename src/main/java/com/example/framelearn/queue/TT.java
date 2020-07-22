package com.example.framelearn.queue;

/**
 * @author jt
 * @date 2020-7-19
 */
public class TT {

    static {
        System.out.println("加载外部类。。。。。");
    }

    public TT(){
        System.out.println("构造方法执行。。。。");
    }

    public static class  builder{

        public builder() {
            System.out.println("静态内部初始化。。。。。");
        }
    }
}

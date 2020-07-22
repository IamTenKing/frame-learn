package com.example.framelearn.staticTest;

/**
 * @author jt
 * @date 2020-7-21
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        //默认使用无参构造方法创建
        Pojo pojo1 = Pojo.class.newInstance();
        Pojo pojo2 = Pojo.class.newInstance();


        //类静态变量，不管是单例还是多例都是共享
        //就算时每次反射生成新类，静态变量还是有并发风险，所以除非是final
        //就算时每次反射生成新类，静态变量还是有并发风险，所以除非是final
        //静态变量是类加载的时候
        System.out.println("=============:" +( pojo1.getPojo()==pojo2.getPojo()));

    }
}

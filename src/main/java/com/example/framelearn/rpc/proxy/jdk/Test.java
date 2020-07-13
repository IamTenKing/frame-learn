package com.example.framelearn.rpc.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 *
 * 动态代理给封装了统一的增加逻辑，能增强所有的实现类
 *
 * jdk 原生动态代理
 *
 * jdk动态代理是jdk原生就支持的一种代理方式，它的实现原理，就是通过让target类和代理类实现同一接口，
 * 代理类持有target对象，来达到方法拦截的作用，这样通过接口的方式有两个弊端，一个是必须保证target类有接口，
 * 第二个是如果想要对target类的方法进行代理拦截，那么就要保证这些方法都要在接口中声明，实现上略微有点限制。
 * @author jt
 * @date 2020-6-5
 */
public class Test {
    public static void main(String[] args) {

        //接口实现类
        UserServiceImpl userService = new UserServiceImpl();

        //增强方法类
        InvocationHandler invocationHandler = new MyInvocationHandler(userService);

        //代理类,跟实现类同一个接口
//        UserService userServiceProxy = (UserService)Proxy.newProxyInstance(userService.getClass().getClassLoader(),
//                userService.getClass().getInterfaces(),
//                invocationHandler);

        UserService userServiceProxy = (UserService)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
               new Class[]{UserService.class},
                invocationHandler);

        //通过代理类执行方法，实际执行的是代理类的逻辑
        System.out.println(userServiceProxy.getName(1));
        System.out.println(userServiceProxy.getAge(1));

    }



}

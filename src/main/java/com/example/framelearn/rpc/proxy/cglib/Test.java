package com.example.framelearn.rpc.proxy.cglib;

import com.example.framelearn.rpc.proxy.jdk.UserService;
import com.example.framelearn.rpc.proxy.jdk.UserServiceImpl;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @author jt
 * @date 2020-6-5
 */
public class Test {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();

        Enhancer enhancer = new Enhancer();
        //自动创建子类，所以不需要接口
        enhancer.setSuperclass(UserServiceImpl.class);
        enhancer.setCallback(cglibProxy);

        UserService o = (UserService)enhancer.create();
        o.getName(1);
        o.getAge(1);

    }
}

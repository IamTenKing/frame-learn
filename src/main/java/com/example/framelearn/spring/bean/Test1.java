package com.example.framelearn.spring.bean;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * @author jt
 * @date 2020-7-21
 */
@Component
public class Test1 implements InitializingBean, DisposableBean {

    public Test1() {
        System.out.println("執行test構造方法。。。。。。。。。。。。。。。。。");
    }

    @Override
    public void destroy() throws Exception {

        System.out.println("執行test  destroy方法。。。。。。。。。。。。。。。。。");

    }

    /**
     * 构造方法，属性赋值以后就执行。。。
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("執行test  afterPropertiesSet方法。。。。。。。。。。。。。。。。。");
    }
}

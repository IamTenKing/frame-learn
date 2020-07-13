package com.example.framelearn.rpc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * 判断是否为代理类
 * @author jt
 * @date 2020-7-2
 */
public class ProxyDemo {
    public static void main(String[] args) throws Exception {
        InvocationHandler handler = new SampleInvocationHandler();

        Class proxyClass = Proxy.getProxyClass(
                SampleClass.class.getClassLoader(),
                SampleInterface.class);


        SampleInterface proxy = (SampleInterface) proxyClass.getConstructor(
                new Class[] { InvocationHandler.class }).newInstance(
                new Object[] { handler });


        System.out.println(Proxy.isProxyClass(proxyClass));

        SampleInterface  sample = (SampleInterface)Proxy.newProxyInstance(SampleClass.class.getClassLoader(), new Class[]{SampleInterface.class}, handler);
        System.out.printf("测试==========:%s%n", new Object[]{Proxy.isProxyClass(sample.getClass())});

    }
}

class SampleInvocationHandler implements InvocationHandler {

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        System.out.println("Welcome To Yiibai.com");
        return null;
    }
}

interface SampleInterface {
    void showMessage();
}

class SampleClass implements SampleInterface {
    @Override
    public void showMessage() {
        System.out.println("Hello World");
    }//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/javareflect/javareflect_proxy_isproxyclass.html


}

package com.example.framelearn.rpc.serviceloader;

/**
 * @author jt
 * @date 2020-6-4
 */
public class MyServiceLoaderImpl2 implements IMyServiceLoader {
    @Override
    public String sayHello() {
        return "hello2";
    }

    @Override
    public String getName() {
        return "name2";
    }
}

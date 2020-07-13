package com.example.framelearn.rpc.serviceloader;

import java.util.ServiceLoader;

/**
 *
 * spi
 * SPI全称Service Provider Interface，是Java提供的一套用来被第三方实现或者扩展的接口，它可以用来启用框架扩展和替换组件。 SPI的作用就是为这些被扩展的API寻找服务实现。
 * @author jt
 * @date 2020-6-4
 */
public class TestMyServiceLoader {
    public static void main(String[] argus){

        //ServiceLoader.load 通过接口加载META-INF/services所有实现类
        ServiceLoader<IMyServiceLoader> serviceLoader = ServiceLoader.load(IMyServiceLoader.class);
        for (IMyServiceLoader myServiceLoader : serviceLoader){
            System.out.println(myServiceLoader.getName() + myServiceLoader.sayHello());
        }
    }
}
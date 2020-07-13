package com.example.framelearn.stream;

import com.example.framelearn.rpc.serviceloader.IMyServiceLoader;

import java.util.ServiceLoader;
import java.util.stream.StreamSupport;

/**
 *
 * SPI全称Service Provider Interface，是Java提供的一套用来被第三方实现或者扩展的接口，它可以用来启用框架扩展和替换组件。 SPI的作用就是为这些被扩展的API寻找服务实现。
 * @author jt
 * @date 2020-6-4
 */
public class StreamSupportDemo {

    public static void main(String[] args) throws ClassNotFoundException {

        String clasz = "com.example.framelearn.rpc.serviceloader.IMyServiceLoader";
        Class<?> aClass = Class.forName(clasz);

        Object o = StreamSupport.
                stream(ServiceLoader.load(aClass).spliterator(), false)
                .map(StreamSupportDemo::setData)
                .findFirst().orElseThrow(RuntimeException::new);

    }



    public static Object setData(Object student){
        IMyServiceLoader student1 = (IMyServiceLoader) student;
        System.out.println(student1.sayHello());

        return student1;
    }
}
